package fsktm.um.edu.mymajor;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private TextView question, noIndicator;
    private LinearLayout optionContainer;
    private Button cancelBtn, nextBtn;
    private int count=0;
    private List<QuestionModel> list ;
    private int position = 0;
    private int score = 0;
    private String category;
    private int setNo;

    private Dialog loadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.numberIndicator);

        optionContainer = findViewById(R.id.optionsContainer);
        cancelBtn = findViewById(R.id.cancel_btn);
        nextBtn = findViewById(R.id.next_btn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /*
        list = new ArrayList<>();
        list.add(new QuestionModel("question 1","a","b","c","d","a"));
        list.add(new QuestionModel("question 2","a","b","c","d","a"));
        list.add(new QuestionModel("question 3","a","b","c","d","b"));
        list.add(new QuestionModel("question 4","a","b","c","d","c"));
        list.add(new QuestionModel("question 5","a","b","c","d","b"));
        list.add(new QuestionModel("question 6","a","b","c","d","d"));
        list.add(new QuestionModel("question 7","a","b","c","d","a"));
        list.add(new QuestionModel("question 8","a","b","c","d","c"));
        list.add(new QuestionModel("question 9","a","b","c","d","b"));
        list.add(new QuestionModel("question 10","a","b","c","d","d"));
        list.add(new QuestionModel("question 11","a","b","c","d","b"));
        list.add(new QuestionModel("question 12","a","b","c","d","d"));
*/

        category = getIntent().getStringExtra("category");
        setNo = getIntent().getIntExtra("setNo",1);

        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading);
        loadingDialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);

        list = new ArrayList<>();

        loadingDialog.show();
        myRef.child("SETS").child(category).child("questions").orderByChild("setNo").equalTo(setNo).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    list.add(snapshot.getValue(QuestionModel.class));
                }
                if(list.size()>0){


                    for(int i=0;i<4;i++){
                        optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                checkAnswer((Button) view);
                            }
                        });
                    }

                    playAnim(question,0,list.get(position).getQuestion());

                    nextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            nextBtn.setEnabled(false);
                            nextBtn.setAlpha(0.7f);
                            enableOption(true);
                            position++;
                            if(position == list.size()){
                                Intent scoreIntent = new Intent(QuestionsActivity.this,ScoreActivity.class);
                                scoreIntent.putExtra("score", score);
                                scoreIntent.putExtra("total", list.size());
                                startActivity(scoreIntent);
                                finish();
                                return;
                            }
                            count=0;
                            playAnim(question,0, list.get(position).getQuestion());
                        }
                    });
                }
                else {
                    finish();
                    Toast.makeText(QuestionsActivity.this,"No questions available", Toast.LENGTH_SHORT).show();
                }
                loadingDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(QuestionsActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                loadingDialog.dismiss();
                finish();
            }
        });
    }


    private void playAnim(final View view, final int value, final String data){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                if(value==0 && count<4){
                    String option="";
                    if(count==0){
                        option = list.get(position).getOptionA();
                    }else if(count==1){
                        option = list.get(position).getOptionB();

                    }else if(count==2){
                        option = list.get(position).getOptionC();

                    }else if(count==3){
                        option = list.get(position).getOptionD();

                    }
                    playAnim(optionContainer.getChildAt(count),0, option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                if(value==0){
                    try{

                        ((TextView)view).setText(data);
                        noIndicator.setText(position+1+"/"+list.size());

                    }catch(ClassCastException ex){
                        ((Button)view).setText(data);

                    }
                    view.setTag(data);
                    playAnim(view , 1,data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void checkAnswer(Button selecedOption){
        enableOption(false);
        nextBtn.setEnabled(true);
        nextBtn.setAlpha(1);

        if(selecedOption.getText().toString().equals(list.get(position).getCorrectAns())){
            //correct
            score++;
            selecedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));

        }
        else{
            //incorrect
            selecedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            Button correctOption = (Button) optionContainer.findViewWithTag(list.get(position).getCorrectAns());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));

        }

    }


    private void enableOption(boolean enable){
        for(int i=0;i<4;i++) {
            optionContainer.getChildAt(i).setEnabled(enable);
            if(enable){
                optionContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }
}