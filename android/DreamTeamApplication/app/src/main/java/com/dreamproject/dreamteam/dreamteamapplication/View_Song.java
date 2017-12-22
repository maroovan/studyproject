package com.dreamproject.dreamteam.dreamteamapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class View_Song extends AppCompatActivity {

    String SONG_GET_NAME; //сюда мы получим имя песни
    String BAND_GET_NAME; //сюда мы получим имя группы
    String GET_LYRICS; //сюда мы получим имя группы
    TextView SONGTITLE;
    TextView BANDTITLE;
    TextView SONGTEXT;

    String Lyrics = "Somebody once told me the world is gonna roll me\n" +
            "I ain't the sharpest tool in the shed\n" +
            "She was looking kind of dumb with her finger and her thumb\n" +
            "In the shape of an \"L\" on her forehead\n\n" +
            "Well the years start coming and they don't stop coming\n" +
            "Fed to the rules and I hit the ground running\n" +
            "Didn't make sense not to live for fun\n" +
            "Your brain gets smart but your head gets dumb\n" +
            "So much to do, so much to see\n" +
            "So what's wrong with taking the back streets?\n" +
            "You'll never know if you don't go\n" +
            "You'll never shine if you don't glow\n\n" +
            "Hey now, you're an all-star, get your game on, go play\n" +
            "Hey now, you're a rock star, get the show on, get paid\n" +
            "And all that glitters is gold\n" +
            "Only shooting stars break the mold\n\n" +
            "It's a cool place and they say it gets colder\n" +
            "You're bundled up now, wait till you get older\n" +
            "But the meteor men beg to differ\n" +
            "Judging by the hole in the satellite picture\n" +
            "The ice we skate is getting pretty thin\n" +
            "The water's getting warm so you might as well swim\n" +
            "My world's on fire, how about yours?\n" +
            "That's the way I like it and I never get bored\n\n" +
            "Hey now, you're an all-star, get your game on, go play\n" +
            "Hey now, you're a rock star, get the show on, get paid\n" +
            "All that glitters is gold\n" +
            "Only shooting stars break the mold\n" +
            "Hey now, you're an all-star, get your game on, go play\n" +
            "Hey now, you're a rock star, get the show, on get paid\n" +
            "And all that glitters is gold\n" +
            "Only shooting stars\n\n" +
            "Somebody once asked could I spare some change for gas?\n" +
            "I need to get myself away from this place\n" +
            "I said yep what a concept\n" +
            "I could use a little fuel myself\n" +
            "And we could all use a little change\n\n" +
            "Well, the years start coming and they don't stop coming\n" +
            "Fed to the rules and I hit the ground running\n" +
            "Didn't make sense not to live for fun\n" +
            "Your brain gets smart but your head gets dumb\n" +
            "So much to do, so much to see\n" +
            "So what's wrong with taking the back streets?\n" +
            "You'll never know if you don't go (go!)\n" +
            "You'll never shine if you don't glow\n\n" +
            "Hey now, you're an all-star, get your game on, go play\n" +
            "Hey now, you're a rock star, get the show on, get paid\n" +
            "And all that glitters is gold\n" +
            "Only shooting stars break the mold\n\n" +
            "And all that glitters is gold\n" +
            "Only shooting stars break the mold";



    public View_Song() {
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

        SONGTEXT = (TextView) findViewById(R.id.view_song_text);
        SONGTEXT.setText(Lyrics);

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