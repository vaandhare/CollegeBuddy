package in.indekode.collegebuddy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfileActivity extends AppCompatActivity {

    EditText uname, uusrname, uyr, ubr, urno, udiv, uemail;
    TextView bt_save;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_profile);

        uname = findViewById(R.id.update_name);
        uusrname = findViewById(R.id.update_username);
        uyr = findViewById(R.id.update_year);
        ubr = findViewById(R.id.update_branch);
        urno = findViewById(R.id.update_rollno);
        udiv = findViewById(R.id.update_div);
        uemail = findViewById(R.id.update_email);

        bt_save = findViewById(R.id.bt_save_update);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                uname.setText(userProfile.getName1());
                uusrname.setText(userProfile.getUsername1());
                uyr.setText( userProfile.getYear());
                ubr.setText(userProfile.getBranch());
                udiv.setText( userProfile.getDivision());
                urno.setText(userProfile.getRno());
                uemail.setText(userProfile.getEmail1());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateProfileActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = uname.getText().toString();
                String newUsrname = uusrname.getText().toString();
                String newYear = uyr.getText().toString();
                String newBranch = ubr.getText().toString();
                String newRollno = urno.getText().toString();
                String newDiv = udiv.getText().toString();
                String newEmail = uemail.getText().toString();

                UserProfile userProfile = new UserProfile(newUsrname, newEmail, newRollno, null, newYear, newBranch, newDiv, newName);
                databaseReference.setValue(userProfile);
                Toast.makeText(UpdateProfileActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
