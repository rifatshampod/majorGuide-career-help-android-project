package fsktm.um.edu.mymajor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity implements SearchResultRecViewAdapter.OnClickListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private TextView scored, total;
    private Button doneBtn;
    private RecyclerView scoreView;
    ArrayList<MajorSubcategoryModel> userMajors = new ArrayList<>();
    ArrayList<MajorSubcategoryModel> allMajors = new ArrayList<>();
    ArrayList<String> userMajorStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scored = findViewById(R.id.scored);
        total = findViewById(R.id.total);
        doneBtn = findViewById(R.id.done_btn);
        scoreView = findViewById(R.id.scoreView);

        userMajorStrings = getIntent().getStringArrayListExtra("user_answers");

        final SearchResultRecViewAdapter adapter = new SearchResultRecViewAdapter(userMajors, this);
        scoreView.setAdapter(adapter);
        scoreView.setLayoutManager(new LinearLayoutManager(this));
        scoreView.setItemAnimator(new DefaultItemAnimator());

        myRef.child("majors").child("categories").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    for (DataSnapshot dataSnapshot2: dataSnapshot1.child("subcategories").getChildren()){
                        allMajors.add(dataSnapshot2.getValue(MajorSubcategoryModel.class));
                    }
                }
                for (int i=0; i<userMajorStrings.size(); i++){
                    for (int j=0; j<allMajors.size(); j++){
                        Log.d("Major To Add", userMajorStrings.get(i));
                        if(userMajorStrings.get(i).equals(allMajors.get(j).getTitle())){
                            userMajors.add(allMajors.get(j));
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database Error!", Toast.LENGTH_SHORT).show();
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(int position) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("majors", userMajors);
//        bundle.putInt("index", position);
//
//        MajorDetails majorDetails = new MajorDetails();
//        majorDetails.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, majorDetails).commit();
//        getFragmentManager().beginTransaction().replace(R.id.frameContainer, majorDetails).commit();
    }
}
