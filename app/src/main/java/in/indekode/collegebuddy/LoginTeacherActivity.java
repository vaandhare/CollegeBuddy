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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginTeacherActivity extends AppCompatActivity {

    String Branches[]={"F.E.","Comp","Mech","Civil","EnTC","Chem"};
    String Fe[]={"Vandana Patil","Sudhir Narale","Sachin Jamadar"};
    String Comp[]={"Ketaki Bhoyar","Suvarna Patil", "Mohini Avatade", "Nalini Yadav"};
    String Mech[]={"Amit Umbrajkaar","Vikas Dive","K.V.L.Bhuvaneswary", "Vishwanath Solapure"};
    String Civil[]={"Amruta Kulkarni","Rohit Deshmukh"," Mithun Sawant"};
    String EnTC[]={"M. H. Thigale", "Sandhya Shinde","Neha Tiwari","Amruta Chore"};
    String Chem[]={"Dhundiraj Deshpande","Minaz Alvi","Pankaj Vardhe"};
    Spinner dept_spinner, techr_spinner;
    EditText getpw;
    Button btnlogin;
    String teacher_pass, techr_name;

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
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });
                        }

                        if(Branches[position].equals("Comp")){
                            comp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(comp);
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });
                        }

                        if(Branches[position].equals("Mech")){
                            mech.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(mech);
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

                        }

                        if(Branches[position].equals("Civil")){
                            civil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(civil);
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

                        }

                        if(Branches[position].equals("EnTC")){
                            entc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(entc);
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

                        }

                        if(Branches[position].equals("Chem")){
                            chem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            techr_spinner.setAdapter(chem);
                            techr_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String teacher_name = techr_spinner.getSelectedItem().toString();
                                    Tvalidate(teacher_name);
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

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
                teacher_pass = getpw.getText().toString();
                if (techr_name.equals("Vandana Patil") && teacher_pass.equals("vandana")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Sudhir Narale") && teacher_pass.equals("sudhir")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Sachin Jamadar") && teacher_pass.equals("sachin")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Ketaki Bhoyar") && teacher_pass.equals("ketaki")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Suvarna Patil") && teacher_pass.equals("suvarna")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Mohini Avatade") && teacher_pass.equals("mohini")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Nalini Yadav") && teacher_pass.equals("nalini")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Amit Umbrajkaar") && teacher_pass.equals("amit")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Vikas Dive") && teacher_pass.equals("vikas")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("K.V.L.Bhuvaneswary") && teacher_pass.equals("kvl")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Vishwanath Solapure") && teacher_pass.equals("vishwanath")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("M. H. Thigale") && teacher_pass.equals("mh")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Sandhya Shinde") && teacher_pass.equals("sandhya")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Neha Tiwari") && teacher_pass.equals("neha")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Amruta Chore") && teacher_pass.equals("amruta")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Dhundiraj Deshpande") && teacher_pass.equals("dhundiraj")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Minaz Alvi") && teacher_pass.equals("minaz")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                }else if (techr_name.equals("Pankaj Vardhe") && teacher_pass.equals("pankaj")){
                    startActivity(new Intent(LoginTeacherActivity.this, TeacherActivity.class));
                } else {
                    Toast.makeText(LoginTeacherActivity.this, "Wrong  Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Tvalidate(String teachername){
        techr_name = teachername;
    }
}
