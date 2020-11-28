package fsktm.um.edu.mymajor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Resume extends AppCompatActivity {

    Button saveResume;
    EditText name, email, phone, address, dob, studylevel, studyYear, studyResult, skill1, skill2;
    SeekBar level1,level2;

    String nameVal, emailVal, phoneVal, addressVal, dobVal, studylevelVal, studyYearVal, studyResultVal, skill1Val, skill2Val;

    int level1Val,level2Val;

    DatabaseReference myDatabase;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        myDatabase = FirebaseDatabase.getInstance().getReference("resume");
        mFirebaseAuth = FirebaseAuth.getInstance();

        saveResume=findViewById(R.id.save_resume_btn);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.contact);
        address = findViewById(R.id.address);
        dob = findViewById(R.id.dob);
        studylevel = findViewById(R.id.study_level);
        studyYear = findViewById(R.id.study_year);
        studyResult = findViewById(R.id.study_result);
        skill1 = findViewById(R.id.skill1);
        level1 = findViewById(R.id.level1);
        skill2 = findViewById(R.id.skill2);
        level2 = findViewById(R.id.level2);


        saveResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Data value --------------------------------------------------

                nameVal = name.getText().toString();
                emailVal = email.getText().toString();
                phoneVal = phone.getText().toString();
                addressVal = address.getText().toString();
                dobVal = dob.getText().toString();
                studylevelVal = studylevel.getText().toString();
                studyYearVal = studyYear.getText().toString();
                studyResultVal = studyResult.getText().toString();
                skill1Val = skill1.getText().toString();
                skill2Val = skill2.getText().toString();

                level1Val = level1.getProgress();
                level2Val = level2.getProgress();
                Toast.makeText(Resume.this,"Data have been saved.",Toast.LENGTH_LONG).show();

                String id = myDatabase.push().getKey();

                Members members = new Members(String.valueOf(mFirebaseAuth.getCurrentUser()), nameVal, emailVal, phoneVal, addressVal, dobVal, studylevelVal, studyYearVal, studyResultVal, skill1Val, skill2Val,level1Val,level2Val);

                myDatabase.child(id).setValue(members);

                Intent cvIntent = new Intent(Resume.this,HomePage.class);
                startActivity(cvIntent);
            }
        });
    }
}
