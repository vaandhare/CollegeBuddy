package in.indekode.collegebuddy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class BottomNavigationDrawer extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    TimetableFragment timetableFragment;
    AttendanceFragment attendanceFragment;
    SyllabusFragment syllabusFragment;
    NotificationFragment notificationFragment;
    EventFragment eventFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_drawer);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.frame_navigation);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        timetableFragment = new TimetableFragment();
        attendanceFragment = new AttendanceFragment();
        syllabusFragment = new SyllabusFragment();
        eventFragment = new EventFragment();
        notificationFragment = new NotificationFragment();

        setFragment(timetableFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.menu_timetable:
                        setFragment(timetableFragment);
                        break;
                    case R.id.menu_attendance:
                        setFragment(attendanceFragment);
                        break;
                    case R.id.menu_syllabus:
                        setFragment(syllabusFragment);
                        break;
                    case R.id.menu_event:
                        setFragment(eventFragment);
                        break;
                    case R.id.menu_notification:
                        setFragment(notificationFragment);
                        break;

                }
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.dotmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_profile:
                Toast.makeText(BottomNavigationDrawer.this, "This is profile but this is not available now", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(BottomNavigationDrawer.this, "This is setting but this is not available now", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                Toast.makeText(BottomNavigationDrawer.this, "This is logout button but this is not available now", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
