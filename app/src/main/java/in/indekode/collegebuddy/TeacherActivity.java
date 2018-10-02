package in.indekode.collegebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherActivity extends AppCompatActivity {

    Button bt_notice, bt_attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        bt_notice = findViewById(R.id.send_notice);
        bt_attendance = findViewById(R.id.update_attendance);

        bt_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherActivity.this, WebviewActivity.class);
                intent.putExtra("url","http://indekode.ml/CollegeBuddy/");
                startActivity(intent);
            }
        });

    }
}
