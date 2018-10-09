package com.paul.mobilelearning;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Object;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView termTextView;
    ListView lessonList;
    ListView selL;
    ArrayAdapter arrayAdapter;

    ArrayList prelimLessons;
    ArrayList midtermLessons;
    ArrayList finalsLessons;
    ArrayList videos, sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prelimLessons = new ArrayList<String>();
        midtermLessons = new ArrayList<String>();
        finalsLessons = new ArrayList<String>();
        videos = new ArrayList<String>();
        sel = new ArrayList<String>();

        sel.add("Please select a term in the navigation bar.");

        prelimLessons.add("Lesson 1: Fundamental Positions of the Arms and Feet");
        prelimLessons.add("Lesson 2: Basic Terminologies and Steps in Folk Dances");
        prelimLessons.add("Lesson 3: TIKLOS");
        prelimLessons.add("Lesson 4: CARIÑOSA");
        prelimLessons.add("Prelim Quiz");

        midtermLessons.add("Lesson 1: CHA CHA CHA");
        midtermLessons.add("Lesson 2: SWING");
        midtermLessons.add("Lesson 3: REGGAE");
        midtermLessons.add("Midterm Quiz");

        finalsLessons.add("Lesson 1: LINE DANCE");
        finalsLessons.add("Lesson 2: INTERPRETATIVE DANCE");
        finalsLessons.add("Lesson 3: HIP HOP");
        finalsLessons.add("Finals Quiz");

        videos.add("LA-WALK");
        videos.add("CARIÑOSA");
        videos.add("CHA CHA CHA");
        videos.add("TIKLOS");
        videos.add("SWING");
        videos.add("REGGAE");
        videos.add("INTERPRETATIVE DANCE");
        videos.add("HIPHOP");




        termTextView = (TextView) findViewById(R.id.term);
        lessonList = (ListView) findViewById(R.id.lessonList);
        displayTerm("PRELIM", prelimLessons);

        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lessons);
        //lessonList.setAdapter(arrayAdapter);

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
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void displayTerm(final String term, final ArrayList<String> lesson){
        termTextView.setText(term);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesson);
        lessonList.setAdapter(arrayAdapter);


        lessonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Intent i = new Intent(getApplicationContext(), Lesson.class);
                i.putExtra("lessonOrQuizName", (String) lesson.get(pos));
                i.putExtra("term", term);
                startActivity(i);
            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prelim) {
            displayTerm("PRELIM", prelimLessons);

        } else if (id == R.id.nav_midterm) {
            displayTerm("MIDTERM", midtermLessons);

        } else if (id == R.id.nav_finals){
            displayTerm("FINALS", finalsLessons);

        } else if (id == R.id.nav_videos) {
            termTextView.setText("VIDEOS");
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, videos);
            lessonList.setAdapter(arrayAdapter);
            lessonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                    Intent i = new Intent(getApplicationContext(), Videos.class);
                    i.putExtra("videoName", (String) videos.get(pos));
                    i.putExtra("term", "VIDEOS");
                    startActivity(i);
                }
            });

        } else if (id == R.id.about) {
            Intent about = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(about);
        } else if(id == R.id.subjectAbout){
            Intent subj = new Intent(getApplicationContext(), AboutSubject.class);
            startActivity(subj);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
