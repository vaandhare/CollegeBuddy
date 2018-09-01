package in.indekode.collegebuddy;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    NumberPicker npstdyear, npstdbranch, npstddiv;
    EditText etvstdroll, etv_password;
    TextView validate_username, txt_username;
    Button login_btn;

    final String Branch[] = {"Branch","Comp.", "Civil", "Mech.", "Chem.", "EnTC"};
    final  String Years[] = {"Year","FE", "SE", "TE", "BE"};
    final String Divs[] = {"Div.","A", "B", "C", "D", "E", "F", "G", "H", "I"};

    String newYear, newBrnach, newDiv;
    String rollno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npstdyear = (NumberPicker) findViewById(R.id.std_year);
        npstdbranch = (NumberPicker) findViewById(R.id.std_branch);
        npstddiv = (NumberPicker) findViewById(R.id.std_div);

        etvstdroll = (EditText) findViewById(R.id.std_rollno);
        validate_username =(TextView) findViewById(R.id.validate_username);
        txt_username = (TextView) findViewById(R.id.txt_username);
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
                newDiv = Divs[newValue];
            }
        };
        npstddiv.setOnValueChangedListener(DivValueChange);



        validate_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = etvstdroll.getText().toString();
                txt_username.setText(newYear+ newBrnach+ newDiv+ rollno);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
