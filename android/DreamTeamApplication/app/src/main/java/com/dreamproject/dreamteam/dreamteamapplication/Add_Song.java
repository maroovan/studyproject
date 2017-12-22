package com.dreamproject.dreamteam.dreamteamapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Add_Song extends AppCompatActivity {

    EditText BAND_NAME;
    EditText SONG_NAME;
    EditText LYRICS;
    TextView hint;
    Button btn_preview;
    Button btn_push;



    public Add_Song() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_song);

        Toolbar toolbar = (Toolbar) findViewById(R.id.song_toolbar);
        SONG_NAME = (EditText) findViewById(R.id.add_song);
        BAND_NAME = (EditText) findViewById(R.id.add_band);
        LYRICS = (EditText) findViewById(R.id.add_lyrics);
        hint = (TextView) findViewById(R.id.hint);
        btn_preview = (Button) findViewById(R.id.btn_preview);
        btn_push = (Button) findViewById(R.id.btn_push);

        hint.setText("");

        toolbar.setTitle("Добавить песню"); //ничего не показываем в тулбаре
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        btn_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BAND_NAME.getText().toString().length() > 0) {
                    if (SONG_NAME.getText().toString().length() > 0) {
                        if (LYRICS.getText().toString().length() > 0) {
                            PreviewSong(BAND_NAME.getText().toString(), SONG_NAME.getText().toString(), LYRICS.getText().toString());
                        }
                        else
                        {
                            hint.setText("Текст песни не может быть пустым");
                        }
                    }
                    else
                    {
                        hint.setText("Название песни не может быть пустым");
                    }

                }
                else
                {
                    hint.setText("Название группы не может быть пустым");
                }
            }
        });

        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BAND_NAME.getText().toString().length() > 0) {
                    if (SONG_NAME.getText().toString().length() > 0) {
                        if (LYRICS.getText().toString().length() > 0) {
                            PushSong(BAND_NAME.getText().toString(), SONG_NAME.getText().toString(), LYRICS.getText().toString());
                        }
                        else
                        {
                            hint.setText("Текст песни не может быть пустым");
                        }
                    }
                    else
                    {
                        hint.setText("Название песни не может быть пустым");
                    }

                }
                else
                {
                    hint.setText("Название группы не может быть пустым");
                }
            }
        });

    }

    void PreviewSong(String song, String band, String lyrics)
    {
        Intent intent = new Intent(this,Preview_Song.class);
        intent.putExtra("SONG_NAME", song);
        intent.putExtra("BAND_NAME", band);
        intent.putExtra("LYRICS", lyrics);
        startActivity(intent);
    }

    void PushSong(String song, String band, String lyrics)
    {
        Intent intent = new Intent(this,MainActivity_logged.class);
        intent.putExtra("SONG_NAME", song);
        intent.putExtra("BAND_NAME", band);
        intent.putExtra("SONG_IS_ADDED", "YES"); //говорим о том, что добавили песню
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //убираем предыдущие экраны ибо костыль
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}