package in.indekode.collegebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    NumberPicker npstdyear, npstdbranch, npstddiv;
    EditText reg_email, reg_password, reg_roll_no;
    TextView  reg_username, reg_login;
    Button reg_validate, bt_register;

    FirebaseAuth firebaseAuth;

    final String Branch[] = {"Branch","Comp", "Civil", "Mech", "Chem", "EnTC"};
    final  String Years[] = {"Year","FE", "SE", "TE", "BE"};
    final String Divs[] = {"Div","A", "B", "C", "D", "E", "F", "G", "H", "I"};

    String email, rno,  username, password,RnewYear, RnewBrnach, RnewDiv,Ruser_name, Rrollno,ny,nb, nd;
    String un = "Username = ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        npstdyear =  findViewById(R.id.r_std_year);
        npstdbranch =  findViewById(R.id.r_std_branch);
        npstddiv =  findViewById(R.id.r_std_div);

        reg_email =  findViewById(R.id.r_etv_email);
        reg_password =  findViewById(R.id.r_etv_password);
        reg_roll_no =  findViewById(R.id.r_std_rollno);

        reg_validate =  findViewById(R.id.r_validate_username);
        reg_username =  findViewById(R.id.r_txt_username);
        reg_login =  findViewById(R.id.r_already_user);

        bt_register =  findViewById(R.id.r_btn_register);

        npstdyear.setMinValue(0);
        npstdyear.setMaxValue(Years.length-1);
        npstdyear.setDisplayedValues(Years);
        npstdyear.setDescendantFocusability(NumberPicker.FOCUS_AFTER_DESCENDANTS);

        NumberPicker.OnValueChangeListener YearValueChange = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                if( newValue == 0)
                    Toast.makeText(RegistrationActivity.this, "This will cause Error!, Please choose correct year value", Toast.LENGTH_SHORT).show();
                else
                    RnewYear = Years[newValue];
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
                    Toast.makeText(RegistrationActivity.this, "This will cause Error!, Please choose correct Branch value", Toast.LENGTH_SHORT).show();
                else
                    RnewBrnach = Branch[newValue];
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
                    Toast.makeText(RegistrationActivity.this, "This will cause Error!, Please choose correct Div value", Toast.LENGTH_SHORT).show();
                else
                    RnewDiv = Divs[newValue];
            }
        };
        npstddiv.setOnValueChangedListener(DivValueChange);

        reg_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rrollno = reg_roll_no.getText().toString();
                if ( !Rrollno.isEmpty()) {
                    Ruser_name = RnewYear + RnewBrnach + RnewDiv + Rrollno;
                    reg_username.setText(un + Ruser_name);
                }
                else
                    Toast.makeText(RegistrationActivity.this, "This will cause Error!, Please choose correct values", Toast.LENGTH_SHORT).show();
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String emailuser = reg_email.getText().toString().trim();
                    String passworduser = reg_password.getText().toString().trim();
                    //String nameUser = Ruser_name;

                    firebaseAuth.createUserWithEmailAndPassword(emailuser, passworduser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(RegistrationActivity.this, "Registration Successful !!", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();

                            }else {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        reg_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });


    }

    public boolean validate(){
        Boolean result = false;

        rno = reg_roll_no.getText().toString();
        email = reg_email.getText().toString();
        password = reg_password.getText().toString();
        username = Ruser_name;
        ny = RnewYear;
        nb = RnewBrnach;
        nd = RnewDiv;

        if (RnewYear.equals("Branch") || RnewBrnach.equals("Year") || RnewDiv.equals("Div") || rno.isEmpty() || RnewYear.isEmpty() || RnewDiv.isEmpty() || RnewBrnach.isEmpty() || email.isEmpty() || password.isEmpty() ){
            Toast.makeText(this, "Enter all Inputs", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }
        return result;

    }

    public void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(username, email, rno, password, ny, nb, nd);
        databaseReference.setValue(userProfile);
    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser1 = firebaseAuth.getCurrentUser();
        if(firebaseUser1 != null){
            firebaseUser1.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if ( task.isSuccessful()){
                        sendUserData();
                        Toast.makeText(RegistrationActivity.this, "Verification link is send to your Email-id", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    }else {
                        Toast.makeText(RegistrationActivity.this, "Failed to send verification Email",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
