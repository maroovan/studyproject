package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 26.11.2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class fragment_profile_page extends Fragment{

    public fragment_profile_page() {
        // Required empty public constructor
    }

    //Переменные
    TextView Username;
    TextView Rating;
    ListView AddedSongs;
    TextView CountSongs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Добавим песен для виду

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Username = (TextView) view.findViewById(R.id.profile_username);
        Rating = (TextView) view.findViewById(R.id.profile_rating);
        AddedSongs = (ListView) view.findViewById(R.id.profile_added_songs);
        CountSongs = (TextView) view.findViewById(R.id.profile_count_songs);

        return view;
    }

}
