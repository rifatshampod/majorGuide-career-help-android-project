package fsktm.um.edu.mymajor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ResumeShow extends AppCompatActivity {

    TextView name, email, phone, address, dob, studylevel, studyYear, studyResult, skill1, skill2;
    SeekBar level1,level2;

    String userId = "abcd";

    int memberLevel1 = 0;
    int memberLevel2 = 0;


    Query mydb;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_show);

        mFirebaseAuth = FirebaseAuth.getInstance();

        userId = String.valueOf(mFirebaseAuth.getCurrentUser());


        mydb = FirebaseDatabase.getInstance().getReference("resume").orderByChild("memberId").equalTo(userId);

        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        phone= findViewById(R.id.phone);
        address= findViewById(R.id.address);
        dob= findViewById(R.id.dob);
        studylevel= findViewById(R.id.study_level);
        studyYear= findViewById(R.id.study_year);
        studyResult= findViewById(R.id.study_result);
        skill1= findViewById(R.id.skill1);
        skill2= findViewById(R.id.skill2);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);

        mydb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String memberID = dataSnapshot.child("memberId").getValue(String.class);
                String memberName = dataSnapshot.child("name").getValue(String.class);
                String memberEmail = dataSnapshot.child("email").getValue(String.class);
                String memberDob = dataSnapshot.child("dob").getValue(String.class);
                String memberAddress = dataSnapshot.child("address").getValue(String.class);
                String memberPhone = dataSnapshot.child("phone").getValue(String.class);
                String memberStudyLevel = dataSnapshot.child("studylevel").getValue(String.class);
                String memberStudyYear = dataSnapshot.child("studyYear").getValue(String.class);
                String memberstudyResult = dataSnapshot.child("studyResult").getValue(String.class);
                String memberSkill1 = dataSnapshot.child("skill1").getValue(String.class);
                String memberSkill2 = dataSnapshot.child("skill2").getValue(String.class);

                //memberLevel1 = Integer.valueOf(dataSnapshot.child("level1").getValue(Integer.class));

                //memberLevel2 = dataSnapshot.child("level2").getValue(Integer.class);


                name.setText(memberName);
                email.setText(memberEmail);
                phone.setText(memberPhone);
                address.setText(memberAddress);
                dob.setText(memberDob);
                studylevel.setText(memberStudyLevel);
                studyYear.setText(memberStudyYear);
                studyResult.setText(memberstudyResult);
                skill1.setText(memberSkill1);
                skill2.setText(memberSkill2);
                level1.setProgress(memberLevel1);
                level2.setProgress(memberLevel2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ResumeShow.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }
}
