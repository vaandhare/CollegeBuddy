package in.indekode.collegebuddy;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    NumberPicker npstdyear, npstdbranch, npstddiv;
    EditText etvstdroll, etv_password, etv_email;
    TextView validate_username, txt_username, attempt, bt_register, bt_forgot_password;
    Button login_btn;

    int counter = 5;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    final String Branch[] = {"Branch","Comp", "Civil", "Mech", "Chem", "EnTC"};
    final  String Years[] = {"Year","FE", "SE", "TE", "BE"};
    final String Divs[] = {"Div","A", "B", "C", "D", "E", "F", "G", "H", "I"};

    String newYear, newBrnach, newDiv;
    String rollno, user_name;
    String un = "Username = ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npstdyear = (NumberPicker) findViewById(R.id.std_year);
        npstdbranch = (NumberPicker) findViewById(R.id.std_branch);
        npstddiv = (NumberPicker) findViewById(R.id.std_div);
        attempt = (TextView) findViewById(R.id.attempts);
        bt_register = (TextView) findViewById(R.id.register);
        bt_forgot_password = (TextView) findViewById(R.id.forgotpassword);

        etvstdroll = (EditText) findViewById(R.id.std_rollno);
        validate_username =(TextView) findViewById(R.id.validate_username);
        txt_username = (TextView) findViewById(R.id.txt_username);
        etv_email = (EditText) findViewById(R.id.etv_email);

        login_btn = (Button)findViewById(R.id.btn_login);

        etv_password = (EditText) findViewById(R.id.etv_password);

        //Number Picker for Branch Year nad Div

        npstdyear.setMinValue(0);
        npstdyear.setMaxValue(Years.length-1);
        npstdyear.setDisplayedValues(Years);
        npstdyear.setDescendantFocusability(NumberPicker.FOCUS_AFTER_DESCENDANTS);

        NumberPicker.OnValueChangeListener YearValueChange = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                if( newValue == 0)
                    Toast.makeText(MainActivity.this, "This will cause Error!, Please choose correct year value", Toast.LENGTH_SHORT).show();
                else
                    newYear = Years[newValue];
            }
        };
        npstdyear.setOnValueChangedListener(YearValueChange);

        npstdbranch.setMinValue(0);
        npstdbranch.setMaxValue(Branch.length-1);
        npstdbranch.setDisplayedValues(Branch);
        npstdbranch.setDescendantFocusability(NumberPicker.FOCUS_AFTER_DESCENDANTS);

        NumberPicker.OnValueChangeListener BranchValueChange = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                if( newValue == 0)
                    Toast.makeText(MainActivity.this, "This will cause Error!, Please choose correct Branch value", Toast.LENGTH_SHORT).show();
                else
                    newBrnach = Branch[newValue];
            }
        };
        npstdbranch.setOnValueChangedListener(BranchValueChange);

        npstddiv.setMinValue(0);
        npstddiv.setMaxValue(Divs.length-1);
        npstddiv.setDisplayedValues(Divs);
        npstddiv.setDescendantFocusability(NumberPicker.FOCUS_AFTER_DESCENDANTS);

        NumberPicker.OnValueChangeListener DivValueChange = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                if( newValue == 0)
                    Toast.makeText(MainActivity.this, "This will cause Error!, Please choose correct Div value", Toast.LENGTH_SHORT).show();
                else
                    newDiv = Divs[newValue];
            }
        };
        npstddiv.setOnValueChangedListener(DivValueChange);


        validate_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = etvstdroll.getText().toString();
                if ( !rollno.isEmpty()) {
                    user_name = newYear + newBrnach + newDiv + rollno;
                    txt_username.setText(un +user_name);
                }
                else
                    Toast.makeText(MainActivity.this, "This will cause Error!, Please choose correct values", Toast.LENGTH_SHORT).show();
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if( user != null){
            finish();
            startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
        }

        login_btn.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etv_email.getText().toString(), etv_password.getText().toString());
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

    }

    private  void validate(final String username, final String passwords){

        progressDialog.setMessage("Connecting to the Server....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    checkVerification();
                }
                else {
                    progressDialog.dismiss();
                    counter--;
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    attempt.setText(counter + " attempts left.");
                    if (counter == 0) {
                        login_btn.setEnabled(false);
                    }
                }
            }
        });
    }

    private void checkVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();

        if (emailFlag){
            startActivity(new Intent(this, NavigationDrawerActivity.class));
        }else {
            Toast.makeText(this, "Verify your Email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }


}
