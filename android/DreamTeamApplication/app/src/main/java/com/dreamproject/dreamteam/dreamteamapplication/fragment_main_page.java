package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 19.12.2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


public class fragment_main_page extends Fragment {



    public fragment_main_page() {
        // Required empty public constructor

    }

    ListView BANDS;
    SearchView SEARCH;

    static final String[] FAKE_BANDS = new String[] { "Beatles", "Bibio", "Disasterpeace", "King Gizzard The Lizard Wizard",
            "Led Zeppelin", "Local Natives", "Marilyn Manson", "Nirvana", "Radiohead",
            "System of a Down", "Tame Impala", "Them Crooked Vultures", "Unknown Mortal Orchestra"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        SEARCH = (SearchView) view.findViewById(R.id.search);
        SEARCH.onActionViewCollapsed(); //вырубаем сраную клавиатуру, которая каждый раз открывается хер пойми зачем
        //SEARCH.onActionViewExpanded();

        //Добавим групп
        BANDS = (ListView) view.findViewById(R.id.main_bands);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.bands_list, R.id.any_song_title, FAKE_BANDS);
        BANDS.setAdapter(adapter);

        BANDS.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                //получаем название группы
                String item = (String) BANDS.getAdapter().getItem(position);
                //посылаем его в следующий активити и запускаем активити
                Intent intent = new Intent(getActivity(), Band_Songs.class);
                intent.putExtra("SONG_NAME", item);
                startActivity(intent);
            }
        });

        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
       //getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(SEARCH.getWindowToken(), 0);
    }


    /*
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        String item = (String) getListAdapter().getItem(position); //получаем имя

    }
    */



}

