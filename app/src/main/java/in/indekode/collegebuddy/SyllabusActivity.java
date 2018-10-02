package in.indekode.collegebuddy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SyllabusActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

    ExpandableListView listView1;
    ExpandableListAdapterr listAdapter1;
    List<String> listDataHeader;
    HashMap<String,List<String>> listHash;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    String sbranch, syear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                syear =  userProfile.getYear();
                sbranch = userProfile.getBranch();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SyllabusActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        listView1 = findViewById(R.id.elv);
        initData();
        listAdapter1 = new ExpandableListAdapterr(this, listDataHeader, listHash);
        listView1.setAdapter(listAdapter1);

        listView1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int PI = -1;
            @Override
            public void onGroupExpand(int position) {
                if ( position != PI){
                    listView1.collapseGroup(PI);
                    PI = position;
                }
            }
        });

        //  For List 1
        listView1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                // For Parent 0
                if(i == 0 && i1 == 0) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://www.google.co.in");
                    startActivity(intent);
                }
                else if(i == 0 && i1 == 1) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","http://www3.borutoget.info");
                    startActivity(intent);
                }
                else if(i == 0 && i1 == 2) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://in.linkedin.com");
                    startActivity(intent);
                }

                // For Parent 1
                if(i == 1 && i1 == 0) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://gaana.com");
                    startActivity(intent);
                }
                else if(i == 1 && i1 == 1) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://1337x.to");
                    startActivity(intent);
                }
                else if(i == 1 && i1 == 2) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://www.songsmp3.live");
                    startActivity(intent);
                }

                // For Parent 2
                if(i == 2 && i1 == 0) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://mp3skulls.to");
                    startActivity(intent);
                }
                else if(i == 2 && i1 == 1) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://www.songspk.wiki");
                    startActivity(intent);
                }
                else if(i == 2 && i1 == 2) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","http://convert2mp3.net/en/index.php?p=home");
                    startActivity(intent);
                }

                // For Parent 3
                if(i == 3 && i1 == 0) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://likewap.top/catlist/47704/320-kbps.html");
                    startActivity(intent);
                }
                else if(i == 3 && i1 == 1) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://yts.am");
                    startActivity(intent);
                }
                else if(i == 3 && i1 == 2) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://www8.fmovies.se");
                    startActivity(intent);
                }

                // For Parent 4
                if(i == 4 && i1 == 0) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://www.027ppt.com");
                    startActivity(intent);
                }
                else if(i == 4 && i1 == 1) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","https://clashofclans.com/blog");
                    startActivity(intent);
                }
                else if(i == 4 && i1 == 2) {
                    Intent intent = new Intent(SyllabusActivity.this,WebviewActivity.class);
                    intent.putExtra("url","http://sofdl.com");
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("F.E.");
        listDataHeader.add("Comp");
        listDataHeader.add("Mech");
        listDataHeader.add("Civil");
        listDataHeader.add("EnTC");
        listDataHeader.add("Chem");

        List<String> fe = new ArrayList<>();
        fe.add("Links.");
        fe.add("Video Links");
        fe.add("Documents");

        List<String> comp = new ArrayList<>();
        comp.add("S.E.");
        comp.add("T.E.");
        comp.add("B.E.");

        List<String> mech = new ArrayList<>();
        mech.add("S.E.");
        mech.add("T.E.");
        mech.add("B.E.");

        List<String> civil = new ArrayList<>();
        civil.add("S.E.");
        civil.add("T.E.");
        civil.add("B.E.");

        List<String> entc = new ArrayList<>();
        entc.add("S.E.");
        entc.add("T.E.");
        entc.add("B.E.");

        List<String> chem = new ArrayList<>();
        chem.add("S.E.");
        chem.add("T.E.");
        chem.add("B.E.");

        listHash.put(listDataHeader.get(0),fe);
        listHash.put(listDataHeader.get(1),comp);
        listHash.put(listDataHeader.get(2),mech);
        listHash.put(listDataHeader.get(3),civil);
        listHash.put(listDataHeader.get(4),entc);
        listHash.put(listDataHeader.get(5),chem);
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

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
