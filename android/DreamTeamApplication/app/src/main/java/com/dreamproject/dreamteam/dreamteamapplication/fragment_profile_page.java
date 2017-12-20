package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 26.11.2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    static final String[] FAKE_SONGS = new String[] { "Название песни 1", "Название песни 2", "Название песни 3", "Название песни 4",
            "Название песни 5", "Название песни 6", "Название песни 7", "Название песни 8", "Название песни 9",
            "Название песни 10"};

    static final String[] FAKE_BANDS = new String[] { "Smash Mouth", "Nirvana", "Radiohead", "Black Keys",
            "Бутырка", "Job For A Cowboy", "Взрыв кабачка в коляске с поносом", "Unknown", "Maroovan",
            "Smash Mouth"};


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
        CountSongs.setText(Integer.toString(FAKE_SONGS.length)); //считаем количество песен

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),R.layout.songs_and_bands_list, R.id.any_song_title, FAKE_SONGS);
        AddedSongs.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),R.layout.songs_and_bands_list, R.id.any_band_title, FAKE_BANDS);
        AddedSongs.setAdapter(adapter2);

        return view;
    }

}
