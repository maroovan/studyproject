package com.dreamproject.dreamteam.dreamteamapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Start_log_in extends AppCompatActivity {

    Button btn_log_in;
    Button btn_register;
    EditText login;
    EditText password;
    TextView btn_skip;
    TextView hint;


    public Start_log_in() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_log_in);

        btn_log_in = (Button) findViewById(R.id.btn_log_in);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_skip = (TextView) findViewById(R.id.log_in_later);
        hint = (TextView) findViewById(R.id.enter_hint);
        login = (EditText) findViewById(R.id.email_input);
        password = (EditText) findViewById(R.id.password_input);

        //слушаем кнопки
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckInput()) //проверяем ввод
                    NextScreen(MainActivity_logged.class);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextScreen(Start_register.class);
            }
        });
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextScreen(MainActivity.class);
            }
        });
    }

    public boolean CheckInput(){
        if (login.getText().toString().length() > 0) //ненулевой ник
        {
            if (password.getText().toString().length() >= 6) //минимум 6 символов
            {
                hint.setText(null);
                return true;
            } else {
                hint.setText("Пароль должен содержать минимум 6 символов");
                return false;
            }
        }
        else
        {
            hint.setText("Аккаунт должен содержать хотя бы 1 символ");
            return false;
        }
    }

    void NextScreen(Class item)
    {
        //посылаем его в следующий активити и запускаем активити
        Intent intent = new Intent(this , item);
        intent.putExtra("SONG_IS_ADDED", "NO");
        if (item != Start_register.class)
            finish(); //закрываем
        startActivity(intent);
    }

}