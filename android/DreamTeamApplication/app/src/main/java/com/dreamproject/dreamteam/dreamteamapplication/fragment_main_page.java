package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 19.12.2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.duration;


public class fragment_main_page extends Fragment {



    public fragment_main_page() {
        // Required empty public constructor

    }

    ListView BANDS;
    ListView SONGS;
    SearchView SEARCH;
    View view;
    FloatingActionButton btn_add_songs;


    static final String[] FAKE_BANDS = new String[] { "Beatles", "Bibio", "Disasterpeace", "King Gizzard The Lizard Wizard",
            "Led Zeppelin", "Local Natives", "Marilyn Manson", "Nirvana", "Radiohead",
            "System of a Down", "Tame Impala", "Them Crooked Vultures", "Unknown Mortal Orchestra"};

    //фейковые результаты поиска - список групп
    static final String[] FAKE_SEARCH_BANDS = new String[] { "BeatBox", "Beatles", "Beating Hearts"};
    //фейковые результаты поиска - название группы и песни
    private static final String[] FAKE_SEARCH_SONGS_TITLES =  { "A Hard Days Night", "A Day In a Life","All My Loving", "Baby's in Black", "I'm Only Sleeping"};
    private static final String[] FAKE_SEARCH_SONGS_BANDS =  { "Beatles", "Beatles", "Beatles", "Beatles", "Beatles"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main_page, container, false);

        SEARCH = (SearchView) view.findViewById(R.id.search);
        SEARCH.onActionViewCollapsed(); //вырубаем сраную клавиатуру, которая каждый раз открывается хер пойми зачем
        //SEARCH.onActionViewExpanded();

        //Добавим групп
        BANDS = (ListView) view.findViewById(R.id.main_bands);
        ArrayAdapter<String> adapter_main = new ArrayAdapter<String>(getActivity(),R.layout.bands_list, R.id.any_song_title, FAKE_BANDS);
        BANDS.setAdapter(adapter_main);
        setDynamicHeight(BANDS);

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

        btn_add_songs = (FloatingActionButton) view.findViewById(R.id.add_song);
        btn_add_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Add Song", " - success");
                Intent intent = new Intent(getActivity(), Add_Song.class);
                startActivity(intent);
            }
        });

        if(isAdded()) {
            if (!getActivity().getClass().getSimpleName().equals("MainActivity_logged")) {
                btn_add_songs.hide();
            }
        }

        //ПОИСК
        //слушаем что там по вводу
        SEARCH.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override //поиск по запросу
            public boolean onQueryTextSubmit(String query) {
                Log.i("Search_query", SEARCH.getQuery().toString());

                BANDS = (ListView) view.findViewById(R.id.main_bands);
                ArrayAdapter<String> adapter_band_search = new ArrayAdapter<String>(getActivity(),R.layout.bands_list, R.id.any_song_title, FAKE_SEARCH_BANDS);
                BANDS.setAdapter(adapter_band_search);
                setDynamicHeight(BANDS);

                SONGS = (ListView) view.findViewById(R.id.main_songs);
                ListViewAdapter adapter_song_search = new ListViewAdapter(getActivity(), FAKE_SEARCH_SONGS_TITLES, FAKE_SEARCH_SONGS_BANDS);
                SONGS.setAdapter(adapter_song_search); //настраиваем
                setDynamicHeight(SONGS);

                SONGS.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                        Intent intent = new Intent(getActivity(), View_Song.class);
                        intent.putExtra("SONG_NAME", FAKE_SEARCH_SONGS_TITLES[position]);
                        intent.putExtra("BAND_NAME", FAKE_SEARCH_SONGS_BANDS[position]);
                        startActivity(intent);
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 0) {
                    // Автопоиск
                    Log.i("Search_autoquery", SEARCH.getQuery().toString());
                } else {
                    //возвращаем как было по закрытию
                    Log.i("Search_closed", SEARCH.getQuery().toString());
                    //Возвращаем исходные группы
                    BANDS = (ListView) view.findViewById(R.id.main_bands);
                    ArrayAdapter<String> adapter_main = new ArrayAdapter<String>(getActivity(),R.layout.bands_list, R.id.any_song_title, FAKE_BANDS);
                    BANDS.setAdapter(adapter_main);
                    setDynamicHeight(BANDS);

                    //удаляем список с песнями
                    deleteDynamicHeight(SONGS); //почему-то не работает с нулевым
                    SONGS = (ListView) view.findViewById(R.id.main_songs);
                    ListViewAdapter adapter_song_search = null;
                    SONGS.setAdapter(adapter_song_search); //настраиваем
                }
                return false;
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


    /**
     * Set listview height based on listview children
     *
     * @param listView
     */
    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    public static void deleteDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height -= listItem.getMeasuredHeight();
        }
        //удаляем ещё на единицу, ибо вот так вот
        height -= adapter.getView(0, null, listView).getMeasuredHeight();

        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    //для того чтобы запихнуть в список по 2 параметра (название песни, группы)
    public class ListViewAdapter extends BaseAdapter
    {
        Activity context;
        String title[];
        String description[];

        public ListViewAdapter(Activity context, String[] title, String[] description) {
            super();
            this.context = context;
            this.title = title;
            this.description = description;
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return title.length;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        class ViewHolder {
            TextView txtViewTitle;
            TextView txtViewDescription;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            // TODO Auto-generated method stub
            ViewHolder holder;
            LayoutInflater inflater =  context.getLayoutInflater();

            if (convertView == null)
            {
                convertView = inflater.inflate(R.layout.songs_and_bands_list, null);
                holder = new ViewHolder();
                holder.txtViewTitle = (TextView) convertView.findViewById(R.id.any_song_title);
                holder.txtViewDescription = (TextView) convertView.findViewById(R.id.any_band_title);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txtViewTitle.setText(title[position]);
            holder.txtViewDescription.setText(description[position]);

            return convertView;
        }

    }



}

