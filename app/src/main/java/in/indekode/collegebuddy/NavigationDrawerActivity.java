package in.indekode.collegebuddy;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth firebaseAuth;
    TextView pn,pun,py,pb,pd,prn,pemail;
    FirebaseDatabase firebaseDatabase;
    static String roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Profile");
        pn = findViewById(R.id.usr_name);
        pun = findViewById(R.id.usr_usrname);
        py = findViewById(R.id.usr_year);
        pb = findViewById(R.id.usr_branch);
        pd = findViewById(R.id.usr_div);
        prn = findViewById(R.id.usr_rn);
        pemail = findViewById(R.id.usr_email);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                pn.setText(userProfile.getName1());
                pun.setText(userProfile.getUsername1());
                py.setText(userProfile.getYear());
                pb.setText(userProfile.getBranch());
                pd.setText( userProfile.getDivision());
                roll = userProfile.getRno().toString();
                prn.setText(userProfile.getRno());
                pemail.setText(userProfile.getEmail1());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(NavigationDrawerActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("no", null).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.global, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if ( id == R.id.update_pro){
            startActivity(new Intent(this, UpdateProfileActivity.class));
        }else if (id == R.id.update_pw) {
            startActivity(new Intent(this, UpdatePassword.class));
        }
        else if (id == R.id.nav_logout) {
            firebaseAuth.signOut();
            finish();
            Toast.makeText(this, "Successfully Logout out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        navigation(this, id);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void navigation(Activity activity , int id) {
        switch (id){
            case R.id.nav_Timetable:
                activity.startActivity(new Intent(activity, TimetableActivity.class));
                Toast.makeText(activity, "Timetable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_attendance:
                activity.startActivity(new Intent(activity, AttendanceActivity.class).putExtra("rollno",roll));
                Toast.makeText(activity, "Attendance", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_syllabus:
                activity.startActivity(new Intent(activity, SyllabusActivity.class));
                Toast.makeText(activity, "Syllabus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_events:
                activity.startActivity(new Intent(activity, EventActivity.class));
                Toast.makeText(activity, "Events", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "College Buddy ";
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                activity.startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.nav_aboutUs:
                activity.startActivity(new Intent(activity, AboutUSActivity.class));
                Toast.makeText(activity, "About Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                activity.startActivity(new Intent(activity, NavigationDrawerActivity.class));
                Toast.makeText(activity, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_notice:
                activity.startActivity(new Intent(activity, NoticeActivity.class));
                Toast.makeText(activity, "Notice", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
