package in.indekode.collegebuddy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SyllabusActivity extends AppCompatActivity {

     ExpandableListView listView1, listView2;
     ExpandableListAdapterr listAdapter;
     List<String> listDataHeader;
     HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        listView1 = (ExpandableListView)findViewById(R.id.elv);
        initData();
        listView2 = (ExpandableListView) findViewById(R.id.elv2);
        initData1();
        listAdapter = new ExpandableListAdapterr(this, listDataHeader, listHash);
        listView1.setAdapter(listAdapter);
        listView2.setAdapter(listAdapter);

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

                if(i == 0 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in"));
                    startActivity(bintent);
                }
                else if(i == 0 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.borutoget.info"));
                    startActivity(bintent);
                }
                else if(i == 0 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com"));
                    startActivity(bintent);
                }

                // For Parent 1

                if(i == 1 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gaana.com"));
                    startActivity(bintent);
                }
                else if(i == 1 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://1337x.to"));
                    startActivity(bintent);
                }
                else if(i == 1 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songsmp3.live"));
                    startActivity(bintent);
                }

                // For Parent 2

                if(i == 2 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mp3skulls.to"));
                    startActivity(bintent);
                }
                else if(i == 2 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songspk.wiki"));
                    startActivity(bintent);
                }
                else if(i == 2 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://convert2mp3.net/en/index.php?p=home"));
                    startActivity(bintent);
                }

                // For Parent 3

                if(i == 3 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://likewap.top/catlist/47704/320-kbps.html"));
                    startActivity(bintent);
                }
                else if(i == 3 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yts.am"));
                    startActivity(bintent);
                }
                else if(i == 3 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www8.fmovies.se"));
                    startActivity(bintent);
                }

                // For Parent 4

                if(i == 4 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.027ppt.com"));
                    startActivity(bintent);
                }
                else if(i == 4 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://clashofclans.com/blog"));
                    startActivity(bintent);
                }
                else if(i == 4 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sofdl.com"));
                    startActivity(bintent);
                }
                return false;
            }
        });

        //For list 2

        listView2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                // For Parent 0

                if(i == 0 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in"));
                    startActivity(bintent);
                }
                else if(i == 0 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www3.borutoget.info"));
                    startActivity(bintent);
                }
                else if(i == 0 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com"));
                    startActivity(bintent);
                }

                // For Parent 1

                if(i == 1 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gaana.com"));
                    startActivity(bintent);
                }
                else if(i == 1 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://1337x.to"));
                    startActivity(bintent);
                }
                else if(i == 1 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songsmp3.live"));
                    startActivity(bintent);
                }

                // For Parent 2

                if(i == 2 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mp3skulls.to"));
                    startActivity(bintent);
                }
                else if(i == 2 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.songspk.wiki"));
                    startActivity(bintent);
                }
                else if(i == 2 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://convert2mp3.net/en/index.php?p=home"));
                    startActivity(bintent);
                }

                // For Parent 3

                if(i == 3 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://likewap.top/catlist/47704/320-kbps.html"));
                    startActivity(bintent);
                }
                else if(i == 3 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yts.am"));
                    startActivity(bintent);
                }
                else if(i == 3 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www8.fmovies.se"));
                    startActivity(bintent);
                }

                // For Parent 4

                if(i == 4 && i1 == 0)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.027ppt.com"));
                    startActivity(bintent);
                }
                else if(i == 4 && i1 == 1)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://clashofclans.com/blog"));
                    startActivity(bintent);
                }
                else if(i == 4 && i1 == 2)
                {
                    Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sofdl.com"));
                    startActivity(bintent);
                }
                return false;
            }
        });

    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("Theory Of Computation");
        listDataHeader.add("Database Management System");
        listDataHeader.add("Software Engineering & Project Management");
        listDataHeader.add("Information System & Economical Engineering");
        listDataHeader.add("Compute Networks");

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
        listDataHeader.add("Design and Analysis of Algorithms");
        listDataHeader.add("Systems Programming and Operating System");
        listDataHeader.add(" Embedded Systems and Internet of Things");
        listDataHeader.add(" Software Modeling and Design");
        listDataHeader.add("Web Technology");

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
}