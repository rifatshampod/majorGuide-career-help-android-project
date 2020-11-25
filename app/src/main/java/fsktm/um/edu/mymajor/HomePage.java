package fsktm.um.edu.mymajor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    Button resume, mockTest, logout, test;

    FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mFirebaseAuth = FirebaseAuth.getInstance();

        resume = findViewById(R.id.resumeButton);
        mockTest = findViewById(R.id.mockButton);
        logout = findViewById(R.id.logout_btn);
        test = findViewById(R.id.major_btn);

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resumeIntent = new Intent(HomePage.this, Resume.class);
                startActivity(resumeIntent);
            }
        });

        mockTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mockInt = new Intent(HomePage.this,Category.class);
                startActivity(mockInt);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Toast.makeText(HomePage.this,"You have been logged out",Toast.LENGTH_LONG).show();

                Intent logoutIntent = new Intent(HomePage.this,MainActivity.class);
                startActivity(logoutIntent);

            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this,"key is "+mFirebaseAuth.getCurrentUser(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
