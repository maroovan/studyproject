package com.dreamproject.dreamteam.dreamteamapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Start_register extends AppCompatActivity {

    Button btn_register;
    EditText login;
    EditText password;
    EditText password_confirm;
    TextView hint;


    public Start_register() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        btn_register = (Button) findViewById(R.id.btn_log_in);
        login = (EditText) findViewById(R.id.email_input);
        password = (EditText) findViewById(R.id.password_input);
        password_confirm = (EditText) findViewById(R.id.password_confirm);
        hint = (TextView) findViewById(R.id.login_hint);

        toolbar.setTitle("Регистрация"); //ничего не показываем в тулбаре
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckInput())
                    NextScreen(MainActivity_logged.class);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public boolean CheckInput(){
        if (login.getText().toString().length() > 0) //ненулевой ник
        {
            if (!login.getText().toString().equals("admin"))
            {
                if (password.getText().toString().length() >= 6) //минимум 6 символов
                {
                    if (password.getText().toString().equals(password_confirm.getText().toString())) //пароли одинаковы
                    {
                        hint.setText(null);
                        return true;
                    } else {
                        hint.setText("Пароли не совпадают");
                        return false;
                    }
                } else {
                    hint.setText("Пароль должен содержать минимум 6 символов");
                    return false;
                }
            }
            else
            {
                hint.setText("Такой акаунт уже существует");
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
        finish();
        startActivity(intent);
    }

}