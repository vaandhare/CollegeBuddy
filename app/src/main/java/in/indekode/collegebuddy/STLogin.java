package in.indekode.collegebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class STLogin extends AppCompatActivity {

    Button bt_std, bt_tchr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stlogin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_std = findViewById(R.id.Login_to_std);
        bt_tchr = findViewById(R.id.Login_to_teacher);

        bt_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(STLogin.this, MainActivity.class));
            }
        });

        bt_tchr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(STLogin.this, TeacherActivity.class));
            }
        });

    }

}
