package in.indekode.collegebuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;


public class TimetableActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

     TextClock tc;
     CheckBox cbb1;
     CheckBox cbb2;
     CheckBox cbb3;
     CheckBox cbb4;
     CheckBox cbb5;
     CheckBox cbb6;
     String branch, year;
     ImageView timetable;
     FirebaseAuth firebaseAuth;
     FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable");

        tc = findViewById(R.id.tc1);
        cbb1 = findViewById(R.id.cb1);
        cbb2 = findViewById(R.id.cb2);
        cbb3 = findViewById(R.id.cb3);
        cbb4 = findViewById(R.id.cb4);
        cbb5 = findViewById(R.id.cb5);
        cbb6 = findViewById(R.id.cb6);
        timetable = findViewById(R.id.iv);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                year =  userProfile.getYear();
                branch = userProfile.getBranch();

                switch (year){
                    case "FE" :
                        timetable.setImageResource(R.drawable.ttfe);
                        break;
                    case "SE":
                    case "TE":
                    case "BE":
                        switch (branch){
                            case "Comp":
                                timetable.setImageResource(R.drawable.ttcomp);
                                break;
                            case "Mech":
                                timetable.setImageResource(R.drawable.ttmech);
                                break;
                            case "Civil":
                                timetable.setImageResource(R.drawable.ttcivil);
                                break;
                            case "EnTC":
                                timetable.setImageResource(R.drawable.ttentc);
                                break;
                            case "Chem":
                                timetable.setImageResource(R.drawable.ttchem);
                                break;
                        }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(TimetableActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });


        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {

            case Calendar.MONDAY:
                cbb1.setChecked(true);
                Toast.makeText(this, "MONDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.TUESDAY:
                cbb2.setChecked(true);
                Toast.makeText(this, "TUESDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.WEDNESDAY:
                cbb3.setChecked(true);
                Toast.makeText(this, "WEDNESDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.THURSDAY:
                cbb4.setChecked(true);
                Toast.makeText(this, "THURSDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.FRIDAY:
                cbb5.setChecked(true);
                Toast.makeText(this, "FRIDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.SATURDAY:
                cbb6.setChecked(true);
                Toast.makeText(this, "SATURDAY!", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.global, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_logout) {
            firebaseAuth.signOut();
            finish();
            Toast.makeText(this, "Successfully Logout out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        NavigationDrawerActivity.navigation(this ,id);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}