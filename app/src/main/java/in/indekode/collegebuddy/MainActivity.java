package in.indekode.collegebuddy;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NumberPicker npstdyear, npstdbranch, npstddiv;
    EditText etvstdroll;
    Button submitbtn;

    final String Branch[] = {"Comp.", "Civil", "Mech.", "Chem.", "EnTC"};
    final  String Years[] = {"FE", "SE", "TE", "BE"};
    final String Divs[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

    String newYear, newBrnach, newDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npstdyear = (NumberPicker) findViewById(R.id.std_year);
        npstdbranch = (NumberPicker) findViewById(R.id.std_branch);
        npstddiv = (NumberPicker) findViewById(R.id.std_div);

        etvstdroll = (EditText) findViewById(R.id.std_rollno);
        submitbtn =(Button) findViewById(R.id.btn_submit);

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

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, newYear+ " " + newBrnach + " " + newDiv, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
