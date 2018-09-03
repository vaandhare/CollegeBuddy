package in.indekode.collegebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextClock;

public class TimetableActivity extends AppCompatActivity {

    private  TextClock  tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        tc=(TextClock) findViewById(R.id.tc1);

    }
}
