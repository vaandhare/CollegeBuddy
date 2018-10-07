package in.indekode.collegebuddy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdatePassword extends AppCompatActivity {

    EditText etv_up;
    Button bt_up;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        etv_up = findViewById(R.id.update_pw);
        bt_up = findViewById(R.id.bt_update_pw);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        bt_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newpass = etv_up.getText().toString();

                mFirebaseUser.updatePassword(newpass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UpdatePassword.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                            Toast.makeText(UpdatePassword.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}
