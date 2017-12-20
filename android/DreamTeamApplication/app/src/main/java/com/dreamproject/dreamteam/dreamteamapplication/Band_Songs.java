package com.dreamproject.dreamteam.dreamteamapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Band_Songs extends AppCompatActivity {

    ListView SONGS;
    String BAND_NAME; //сюда мы получим имя группы

    static final String[] FAKE_SONGS = new String[] { "Song 1", "Song 2", "Song 3", "Song 4",
            "Song 5", "Song 6", "Song 7", "Song 8", "Song 9",
            "Song 10", "Song 11", "Song 12", "Song 13"};


    public Band_Songs() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.band_songs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.band_toolbar);
        BAND_NAME = getIntent().getStringExtra("EXTRA_SESSION_ID"); //получаем название группы
        toolbar.setTitle(BAND_NAME); //показываем его в тулбаре
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        SONGS = (ListView) findViewById(R.id.main_band_songs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.songs_list, R.id.label, FAKE_SONGS);
        SONGS.setAdapter(adapter);

    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}