package in.indekode.collegebuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginTeacherActivity extends AppCompatActivity {

    String Branches[]={"F.E.","Comp","Mech","Civil","EnTC","Chem"};
    String Fe[]={"Vandana Patil","Sudhir Narale","Sachin Jamadar"};
    String Comp[]={"Ketaki Bhoyar","Suvarna Patil", "Mohini Avatade", "Nalini Yadav"};
    String Mech[]={"Amit Umbrajkaar","Vikas Dive","K.V.L.Bhuvaneswary", "Vishwanath Solapure"};
    String Civil[]={"Amruta Kulkarni","Rohit Deshmukh"," Mithun Sawant"};
    String EnTC[]={"M. H. Thigale", "Sandhya Shinde","Neha Tiwari","Amruta Chore"};
    String Chem[]={"Dhundiraj Deshpande","Minaz Alvi","Pankaj Vardhe",};
    Spinner dept_spinner, techr_spinner;
    EditText getpw;
    Button btnlogin;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        dept_spinner = findViewById(R.id.s_dept);

        getpw = findViewById(R.id.et_t_pass);
        btnlogin = findViewById(R.id.t_login);

        techr_spinner = findViewById(R.id.s_teacher);
        final ArrayAdapter<String> ia=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item, Branches);
        final ArrayAdapter<String> fe=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,Fe);
        final ArrayAdapter<String> comp=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,Comp);
        final ArrayAdapter<String> mech=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,Mech);
        final ArrayAdapter<String> civil=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,Civil);
        final ArrayAdapter<String> entc=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,EnTC);
        final ArrayAdapter<String> chem=new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item,Chem);
        ia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dept_spinner.setAdapter(ia);
        dept_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int
                    position, long id) {
                switch (parent.getId()){
                    case R.id.s_dept:{
                        if(Branches[position].equals("F.E.")){
                            fe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(fe);
                        }

                        if(Branches[position].equals("Comp")){
                            comp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(comp);
                        }

                        if(Branches[position].equals("Mech")){
                            mech.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(mech);
                        }

                        if(Branches[position].equals("Civil")){
                            civil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(civil);
                        }

                        if(Branches[position].equals("EnTC")){
                            entc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(entc);
                        }

                        if(Branches[position].equals("Chem")){
                            chem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(chem);
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
            }
        });

    }
}
