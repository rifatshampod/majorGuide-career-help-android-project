package fsktm.um.edu.mymajor;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import androidx.annotation.RequiresApi;
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
    private boolean isSetB = false;
    private ArrayList<String> userAnswers = new ArrayList<>();
    private AssessmentChecker assessmentChecker = new AssessmentChecker();
    private ArrayList<MajorSubcategoryModel> userMajors = new ArrayList<>();

    private Dialog loadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

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
        myRef.child("SETS").child(category).child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    list.add(snapshot.getValue(QuestionModel.class));
                }
                if(list.size()>0){
                    for(int i=0;i<3;i++){
                        optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            @Override
                            public void onClick(View view) {
                                checkAnswer((Button) view);
                            }
                        });
                    }

                    playAnim(question,0,list.get(position).getQuestion());

//                    nextBtn.setOnClickListener(new View.OnClickListener() {
//                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//                        @Override
//                        public void onClick(View view) {
//                            nextBtn.setEnabled(false);
//                            nextBtn.setAlpha(0.7f);
//                            enableOption(true);
//                            position++;
//                            if(position == list.size()){
//                                Intent scoreIntent = new Intent(QuestionsActivity.this,ScoreActivity.class);
//                                scoreIntent.putExtra("user_answers", userAnswers);
//                                startActivity(scoreIntent);
//                                finish();
//                                return;
//                            }
//                            count=0;
//                            playAnim(question,0, list.get(position).getQuestion());
//                        }
//                    });
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
                if(value==0 && count<3){
                    String option="";
                    if(count==0){
                        option = list.get(position).getOptionA();
                    }else if(count==1){
                        option = list.get(position).getOptionB();
                    }else if(count==2){
                        option = list.get(position).getOptionC();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkAnswer(Button selectedOption){
        selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));

        userAnswers.add(selectedOption.getText().toString());

        nextBtn.setEnabled(false);
        nextBtn.setAlpha(0.7f);

        int buttonId = 1;
        if(selectedOption.getId() == R.id.button){
            buttonId = 0;
        }

        if(selectedOption.getId() == R.id.button2){
            buttonId = 1;
        }

        if(selectedOption.getId() == R.id.button3){
            buttonId = 2;
        }

        if (isSetB){
            userMajors = assessmentChecker.checkAnswerSetB(list.get(position).getQuestion(), userMajors, buttonId);
        } else {
            userMajors = assessmentChecker.checkAnswer(position, userMajors, buttonId);
        }

        enableOption(true);
        position++;
        if(position == list.size()){
            if (isSetB || userMajors.size()<3){
                Intent scoreIntent = new Intent(QuestionsActivity.this,ScoreActivity.class);
                ArrayList<String> userMajorsTitles = new ArrayList<>();
                for (int i=0; i<userMajors.size(); i++){
                    userMajorsTitles.add(userMajors.get(i).getTitle());
                }

                scoreIntent.putExtra("user_answers", userMajorsTitles);
                startActivity(scoreIntent);
                finish();
                return;
            }

            for (int i=0; i<userMajors.size(); i++){
                Log.d("Before Set B " + i + ": ", userMajors.get(i).getTitle());
            }
            isSetB = true;
            list.addAll(assessmentChecker.generateSetB(userMajors));
        }
        count=0;
        playAnim(question,0, list.get(position).getQuestion());
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void enableOption(boolean enable){
        for(int i=0;i<3;i++) {
            optionContainer.getChildAt(i).setEnabled(enable);
            if(enable){
                optionContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }
}
