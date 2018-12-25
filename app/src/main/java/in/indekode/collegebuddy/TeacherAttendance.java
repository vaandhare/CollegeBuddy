package in.indekode.collegebuddy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherAttendance extends AppCompatActivity {
    Spinner yb;
    EditText s_n, s1_M, s2_M, s3_M, s4_M, s5_M, s_d;
    String by, roll, divi, s1, s2, s3, s4, s5;
    DatabaseReference databaseReference;
    Button get, dataup;
    TextView s;
    String Branches[] = {"F.E.", "Comp", "Mech", "Civil", "EnTC", "Chem"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_attendance);
        yb = (Spinner) findViewById(R.id.ts_dept);
        s_n = (EditText) findViewById(R.id.s_r_n);
        s1_M = (EditText) findViewById(R.id.s1m);
        s2_M = (EditText) findViewById(R.id.s2m);
        s3_M = (EditText) findViewById(R.id.s3m);
        s4_M = (EditText) findViewById(R.id.s4m);
        s5_M = (EditText) findViewById(R.id.s5m);
        s_d = (EditText) findViewById(R.id.s_div);
        get = (Button) findViewById(R.id.get_t);
        s = (TextView) findViewById(R.id.srn);
        dataup = (Button) findViewById(R.id.send_data);
        final ArrayAdapter<String> ia = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, Branches);
        ia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yb.setAdapter(ia);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        yb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                by = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll = s_n.getText().toString();
                divi = s_d.getText().toString();
                s.setText(roll + divi);
            }
        });
        dataup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = s1_M.getText().toString().trim();
                s2 = s2_M.getText().toString().trim();
                s3 = s3_M.getText().toString().trim();
                s4 = s4_M.getText().toString().trim();
                s5 = s5_M.getText().toString().trim();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {

                        for (DataSnapshot postSnapshot :
                                dataSnapshot.getChildren()) {
                            if (postSnapshot.child("rno").getValue().toString().equals(roll)) {
                                postSnapshot.child("sub1").getRef().setValue(s1);
                                postSnapshot.child("sub2").getRef().setValue(s2);
                                postSnapshot.child("sub3").getRef().setValue(s3);
                                postSnapshot.child("sub4").getRef().setValue(s4);
                                postSnapshot.child("sub5").getRef().setValue(s5);
                            }
                        }
                        Toast.makeText(TeacherAttendance.this, "Attendance updated successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override

                    public void onCancelled(DatabaseError databaseError)
                    {

                    }
                });

            }
        });
    }
}