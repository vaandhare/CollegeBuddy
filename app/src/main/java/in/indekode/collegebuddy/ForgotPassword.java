package in.indekode.collegebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText femail;
    Button fbutton;
    FirebaseAuth resetauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        femail = (EditText) findViewById(R.id.forgotemail);
        fbutton = (Button) findViewById(R.id.forgotbutton);
        resetauth = FirebaseAuth.getInstance();

        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resetemail = femail.getText().toString();

                if (resetemail.isEmpty()){
                    Toast.makeText(ForgotPassword.this, "Enter your Registered Email", Toast.LENGTH_SHORT).show();
                }
                else{
                    resetauth.sendPasswordResetEmail(resetemail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if ( task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Password Sent to Registered Email..", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgotPassword.this, MainActivity.class));
                            }
                            else
                                Toast.makeText(ForgotPassword.this, "Email is either not registered or incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
