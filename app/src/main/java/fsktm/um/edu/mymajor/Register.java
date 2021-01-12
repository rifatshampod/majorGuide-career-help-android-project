package fsktm.um.edu.mymajor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class Register extends AppCompatActivity {

    FirebaseAuth userAuth;            // firebase variable

    EditText emailcust, usernamecust, password, confirmPassword;
    Button register;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userAuth = FirebaseAuth.getInstance();

        emailcust=findViewById(R.id.email);
        usernamecust=findViewById(R.id.name);
        password=findViewById(R.id.password);
        confirmPassword = findViewById(R.id.passwordConfirm);
        register=findViewById(R.id.signup);
        login = findViewById(R.id.loginLink);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Register.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailcust.getText().toString().trim();
                final String username = usernamecust.getText().toString().trim();
                String user_password= password.getText().toString().trim();
                String confirm_password= confirmPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(user_password)){
                    password.setError("Password is required.");
                    return;
                }
                if (user_password.length() < 6){
                    password.setError("Password must be >= 6 character ");
                }

                if(!confirm_password.equals(user_password)){
                    password.setError("Passwords did not match ");
                }

                else{
                    userAuth.createUserWithEmailAndPassword(email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username).build();

                                user.updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(Register.this,"User Added successfully",Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(Register.this,MainActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(Register.this,"Error registering user name",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                            else {
                                Toast.makeText(Register.this,"Error Registering new user",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });
    }

}
