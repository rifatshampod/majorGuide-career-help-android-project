package fsktm.um.edu.mymajor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView register, forget;

    DatabaseReference myref;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        myref = FirebaseDatabase.getInstance().getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();

        forget = findViewById(R.id.forgotText);

        if (mFirebaseAuth.getCurrentUser() != null) {                                   //to check if the user is already logged in, no need to log in again
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
            finish();
        }


        register = findViewById(R.id.registerLink);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regintent = new Intent(MainActivity.this, Register.class);
                startActivity(regintent);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //myref.child("user").child("name").setValue("hello");    database connection tested
                Intent forgetIntent = new Intent(MainActivity.this, ForgetPass.class);
                startActivity(forgetIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString().trim();
                String user_password = password.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(user_password)) {
                    password.setError("Passwors is required.");
                    return;
                }
                if (user_password.length() < 6) {
                    password.setError("Password must be >= 6 character ");
                } else {
                    mFirebaseAuth.signInWithEmailAndPassword(email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Log in successful", Toast.LENGTH_LONG).show();
                                Intent homeintent = new Intent(MainActivity.this, HomePage.class);
                                startActivity(homeintent);
                                finish();

                            } else {
                                Toast.makeText(MainActivity.this, "Error singing in. Check user Email/password " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

    }
}

