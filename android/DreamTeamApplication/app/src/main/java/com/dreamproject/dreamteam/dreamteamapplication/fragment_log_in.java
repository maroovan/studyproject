package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 26.11.2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class fragment_log_in extends Fragment{

    public fragment_log_in() {
        // Required empty public constructor
    }

    //наши переменные
    Button btn_log_in;
    Button btn_register;
    EditText email;
    EditText password;

    private static final String TAG = "Profile";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View InputFragmentView = inflater.inflate(R.layout.fragment_page_login, container, false);

        btn_log_in = (Button) InputFragmentView.findViewById(R.id.btn_log_in);
        btn_register = (Button) InputFragmentView.findViewById(R.id.btn_register);
        email = (EditText) InputFragmentView.findViewById(R.id.email_input);
        password = (EditText) InputFragmentView.findViewById(R.id.password_input);

        btn_log_in.setOnClickListener(new View.OnClickListener() //нажатие по Log_In
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), MainActivity_logged.class);
                intent.putExtra("SONG_IS_ADDED", "NO");
                getActivity().finish();
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() //нажатие по Register
        {
            @Override
            public void onClick(View view)
            {
                Log.d(TAG, "register");
            }
        });

        //return inflater.inflate(R.layout.fragment_three, container, false);
        return InputFragmentView;
    }

}
