package com.dreamproject.dreamteam.dreamteamapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Preview_Song extends AppCompatActivity {

    String SONG_GET_NAME; //сюда мы получим имя песни
    String BAND_GET_NAME; //сюда мы получим имя группы
    String GET_LYRICS; //сюда мы получим имя группы
    TextView SONGTITLE;
    TextView BANDTITLE;
    TextView SONGTEXT;




    public Preview_Song() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.song_toolbar);
        SONG_GET_NAME = getIntent().getStringExtra("SONG_NAME"); //получаем название песни
        SONGTITLE = (TextView) findViewById(R.id.view_song_name);
        SONGTITLE.setText(SONG_GET_NAME); //записываем название песни в заголовок

        BANDTITLE = (TextView) findViewById(R.id.view_band_name);
        BAND_GET_NAME = getIntent().getStringExtra("BAND_NAME"); //получаем название группы
        BANDTITLE.setText(" - " + BAND_GET_NAME + " - ");

        GET_LYRICS = getIntent().getStringExtra("LYRICS"); //получаем название группы
        SONGTEXT = (TextView) findViewById(R.id.view_song_text);
        SONGTEXT.setText(GET_LYRICS);

        toolbar.setTitle(""); //ничего не показываем в тулбаре
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}