package in.indekode.collegebuddy;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        viewPager = (ViewPager) findViewById(R.id.pageViewer);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
    }
}
