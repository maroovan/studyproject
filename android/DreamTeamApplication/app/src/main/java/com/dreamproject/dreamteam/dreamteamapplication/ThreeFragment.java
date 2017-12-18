package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 26.11.2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThreeFragment extends Fragment{

    public ThreeFragment() {
        // Required empty public constructor
    }

    //наши кнопки
    Button btn_log_in;
    Button btn_register;
    private static final String TAG = "ThreeFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View InputFragmentView = inflater.inflate(R.layout.fragment_three, container, false);

        btn_log_in = (Button) InputFragmentView.findViewById(R.id.btn_log_in);
        btn_register = (Button) InputFragmentView.findViewById(R.id.btn_register);

        btn_log_in.setOnClickListener(new View.OnClickListener() //нажатие по Log_In
        {
            @Override
            public void onClick(View view)
            {
                Log.d(TAG, "Log in");
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() //нажатие по Register
        {
            @Override
            public void onClick(View view)
            {
                Log.d(TAG, "Register");
            }
        });
        //return inflater.inflate(R.layout.fragment_three, container, false);
        return InputFragmentView;
    }

}
