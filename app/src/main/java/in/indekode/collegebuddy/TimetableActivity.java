package in.indekode.collegebuddy;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.Calendar;


public class TimetableActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextClock tc;
    private CheckBox cbb1;
    private CheckBox cbb2;
    private CheckBox cbb3;
    private CheckBox cbb4;
    private CheckBox cbb5;
    private CheckBox cbb6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tc=(TextClock) findViewById(R.id.tc1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.THURSDAY:
                CheckBox cbb4 = (CheckBox)findViewById(R.id.cb4);
                cbb1.setChecked(true);
                Toast.makeText(this, "THURSDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.MONDAY:
                CheckBox cbb1 = (CheckBox)findViewById(R.id.cb1);
                cbb1.setChecked(true);
                Toast.makeText(this, "MONDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.TUESDAY:
                CheckBox cbb2 = (CheckBox)findViewById(R.id.cb2);
                cbb2.setChecked(true);
                Toast.makeText(this, "TUESDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.WEDNESDAY:
                CheckBox cbb3 = (CheckBox)findViewById(R.id.cb3);
                cbb3.setChecked(true);
                Toast.makeText(this, "WEDNESDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.FRIDAY:
                CheckBox cbb5 = (CheckBox)findViewById(R.id.cb5);
                cbb5.setChecked(true);
                Toast.makeText(this, "FRIDAY!", Toast.LENGTH_SHORT).show();
                break;

            case Calendar.SATURDAY:
                CheckBox cbb6 = (CheckBox)findViewById(R.id.cb6);
                cbb6.setChecked(true);
                Toast.makeText(this, "SATURDAY!", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        NavigationDrawerActivity.navigation(this ,id);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}