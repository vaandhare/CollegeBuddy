package in.indekode.collegebuddy;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();        }
        else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, NavigationDrawerActivity.class));
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        navigation(this, id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
                activity.startActivity(new Intent(activity, AttendanceActivity.class));
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
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Created by Vaibhav, Rohan, Ajinkya, Sneha");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                activity.startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.nav_aboutUs:
                activity.startActivity(new Intent(activity, AboutUSActivity.class));
                Toast.makeText(activity, "About Us", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
