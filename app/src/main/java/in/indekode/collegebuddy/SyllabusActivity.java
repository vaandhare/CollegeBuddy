package in.indekode.collegebuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
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

     ExpandableListView listView1, listView2;
     ExpandableListAdapterr listAdapter1, listAdapter2 ;
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
        listView2 =  findViewById(R.id.elv2);
        initData1();
        listAdapter2 = new ExpandableListAdapterr(this, listDataHeader, listHash);
        listView2.setAdapter(listAdapter2);

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

        listView2.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int PI = -1;
            @Override
            public void onGroupExpand(int position) {
                if ( position != PI){
                    listView2.collapseGroup(PI);
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
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in")));
                }
                else if(i == 0 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.borutoget.info")));
                }
                else if(i == 0 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com")));
                }

                // For Parent 1

                if(i == 1 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://gaana.com")));
                }
                else if(i == 1 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://1337x.to")));
                }
                else if(i == 1 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songsmp3.live")));
                }

                // For Parent 2

                if(i == 2 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mp3skulls.to")));
                }
                else if(i == 2 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songspk.wiki")));
                }
                else if(i == 2 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://convert2mp3.net/en/index.php?p=home")));
                }

                // For Parent 3

                if(i == 3 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://likewap.top/catlist/47704/320-kbps.html")));
                }
                else if(i == 3 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://yts.am")));
                }
                else if(i == 3 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www8.fmovies.se")));
                }

                // For Parent 4

                if(i == 4 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.027ppt.com")));
                }
                else if(i == 4 && i1 == 1) {
                    startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://clashofclans.com/blog")));
                }
                else if(i == 4 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://sofdl.com")));
                }
                return false;
            }
        });

        //For list 2

        listView2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                // For Parent 0
                if(i == 0 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in")));
                }
                else if(i == 0 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.borutoget.info")));
                }
                else if(i == 0 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com")));
                }

                // For Parent 1
                if(i == 1 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://gaana.com")));
                }
                else if(i == 1 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://1337x.to")));
                }
                else if(i == 1 && i1 == 2) {
                    startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songsmp3.live")));
                }

                // For Parent 2
                if(i == 2 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mp3skulls.to")));
                }
                else if(i == 2 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songspk.wiki")));
                }
                else if(i == 2 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://convert2mp3.net/en/index.php?p=home")));
                }

                // For Parent 3
                if(i == 3 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://likewap.top/catlist/47704/320-kbps.html")));
                }
                else if(i == 3 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://yts.am")));
                }
                else if(i == 3 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www8.fmovies.se")));
                }
                // For Parent 4
                if(i == 4 && i1 == 0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.027ppt.com")));
                }
                else if(i == 4 && i1 == 1) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://clashofclans.com/blog")));
                }
                else if(i == 4 && i1 == 2) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://sofdl.com")));
                }
                return false;
            }
        });
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        fesem1();

        List<String> toc = new ArrayList<>();
        toc.add("Links");
        toc.add("Video Links");
        toc.add("Documents");

        List<String> dbms = new ArrayList<>();
        dbms.add("Links");
        dbms.add("Video Links");
        dbms.add("Documents");

        List<String> sepm = new ArrayList<>();
        sepm.add("Links");
        sepm.add("Video Links");
        sepm.add("Documents");

        List<String> isee = new ArrayList<>();
        isee.add("Links");
        isee.add("Video Links");
        isee.add("Documents");

        List<String> cn = new ArrayList<>();
        cn.add("Links");
        cn.add("Video Links");
        cn.add("Documents");

        listHash.put(listDataHeader.get(0),toc);
        listHash.put(listDataHeader.get(1),dbms);
        listHash.put(listDataHeader.get(2),sepm);
        listHash.put(listDataHeader.get(3),isee);
        listHash.put(listDataHeader.get(4),cn);

    }

    private void initData1() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        fesem2();

        List<String> daa = new ArrayList<>();
        daa.add("Links");
        daa.add("Video Links");
        daa.add("Documents");

        List<String> spos = new ArrayList<>();
        spos.add("Links");
        spos.add("Video Links");
        spos.add("Documents");

        List<String> esit = new ArrayList<>();
        esit.add("Links");
        esit.add("Video Links");
        esit.add("Documents");

        List<String> smd = new ArrayList<>();
        smd.add("Links");
        smd.add("Video Links");
        smd.add("Documents");

        List<String> wt = new ArrayList<>();
        wt.add("Links");
        wt.add("Video Links");
        wt.add("Documents");

        listHash.put(listDataHeader.get(0),daa);
        listHash.put(listDataHeader.get(1),spos);
        listHash.put(listDataHeader.get(2),esit);
        listHash.put(listDataHeader.get(3),smd);
        listHash.put(listDataHeader.get(4),wt);

    }

    public void compsem1(){
        listDataHeader.add("Theory Of Computation");
        listDataHeader.add("Database Management System");
        listDataHeader.add("Software Engineering & Project Management");
        listDataHeader.add("Information System & Economical Engineering");
        listDataHeader.add("Compute Networks");
    }

    public void compsem2(){
        listDataHeader.add("Design and Analysis of Algorithms");
        listDataHeader.add("Systems Programming and Operating System");
        listDataHeader.add("Embedded Systems and Internet of Things");
        listDataHeader.add("Software Modeling and Design");
        listDataHeader.add("Web Technology");
    }
    public void fesem1(){
        listDataHeader.add("Mathematics I");
        listDataHeader.add("Engineering Physics");
        listDataHeader.add("Basic Electrical Engineering");
        listDataHeader.add("Basic Civil and Environmental Engineering");
        listDataHeader.add("Engineering Graphics I");
        listDataHeader.add("Fundamental Programming Language I");
    }
    public void fesem2(){
        listDataHeader.add("Mathematics II");
        listDataHeader.add("Engineering Chemistry");
        listDataHeader.add("Basic Electronics Engineering");
        listDataHeader.add("Basic Mechanical Engineering");
        listDataHeader.add("Engineering Mechanics");
        listDataHeader.add("Fundamental Programming Language II");
    }
    public void mechsem1(){

    }
    public void mechsem2(){

    }
    public void chemsem1(){

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