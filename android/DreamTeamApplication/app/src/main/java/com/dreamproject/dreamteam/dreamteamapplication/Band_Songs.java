package com.dreamproject.dreamteam.dreamteamapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Band_Songs extends AppCompatActivity {

    ListView SONGS;
    String BAND_NAME; //сюда мы получим имя группы

    static final String[] FAKE_SONGS = new String[] { "Название песни 1", "Название песни  2", "Название песни  3", "Название песни  4",
            "Название песни  5", "Название песни  6", "Название песни  7", "Название песни  8", "Название песни  9",
            "Название песни  10", "Название песни  11", "Название песни  12", "Название песни  13"};


    public Band_Songs() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.band_songs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.band_toolbar);
        BAND_NAME = getIntent().getStringExtra("SONG_NAME"); //получаем название группы
        toolbar.setTitle(BAND_NAME); //показываем его в тулбаре
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        SONGS = (ListView) findViewById(R.id.main_band_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.songs_list, R.id.any_song_title, FAKE_SONGS);
        SONGS.setAdapter(adapter);

        SONGS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //получаем название группы
                String item = (String) SONGS.getAdapter().getItem(position);
                //посылаем его в следующий активити и запускаем активити
                GoToSong(position);
            }
        });
    }

        void GoToSong(int position)
         {
            String item_song_title = (String) SONGS.getAdapter().getItem(position);
            //посылаем его в следующий активити и запускаем активити
            Intent intent = new Intent(this , View_Song.class);
             intent.putExtra("SONG_NAME", item_song_title);
              intent.putExtra("BAND_NAME", BAND_NAME);
            startActivity(intent);
         }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}