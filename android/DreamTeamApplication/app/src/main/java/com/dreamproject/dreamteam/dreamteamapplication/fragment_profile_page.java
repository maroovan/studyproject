package com.dreamproject.dreamteam.dreamteamapplication;

/**
 * Created by MSI on 26.11.2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;


public class fragment_profile_page extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public fragment_profile_page() {
        // Required empty public constructor
    }

    //Переменные
    TextView Username;
    TextView Rating;
    ListView AddedSongs;
    TextView CountSongs;
    ScrollView scrollview;
    SwipeRefreshLayout update;
    ListViewAdapter list_adapter;


    private static final String[] FAKE_SONGS = { "Название песни 1", "Название песни 2", "Название песни 3", "Название песни 4",
            "Название песни 5", "Название песни 6", "Название песни 7", "Название песни 8", "Название песни 9",
            "Название песни 10"};

    private static final String[] FAKE_BANDS = { "Smash Mouth", "Nirvana", "Radiohead", "Black Keys",
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
        ListViewAdapter list_adapter; //адаптер списка (название песни, группа)

        scrollview = (ScrollView) view.findViewById(R.id.scrollview);
        Username = (TextView) view.findViewById(R.id.profile_username);
        Rating = (TextView) view.findViewById(R.id.profile_rating);
        AddedSongs = (ListView) view.findViewById(R.id.profile_added_songs);
        CountSongs = (TextView) view.findViewById(R.id.profile_count_songs);
        CountSongs.setText(Integer.toString(FAKE_SONGS.length)); //считаем количество песен

        list_adapter = new ListViewAdapter(getActivity(), FAKE_SONGS, FAKE_BANDS);
        AddedSongs.setAdapter(list_adapter); //настраиваем

        scrollview.post(new Runnable() { //скролим вниз, затем вверх, чтобы оказаться наверху страницы (КОСТЫЛЬ)
            public void run() {
                scrollview.fullScroll(View.FOCUS_DOWN);
                scrollview.fullScroll(View.FOCUS_UP);
            }
        });

        setDynamicHeight(AddedSongs);

        AddedSongs.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                //получаем название группы
                //String[] item = (String[]) AddedSongs.getAdapter().getItem(position);
                //посылаем его в следующий активити и запускаем активити
                Intent intent = new Intent(getActivity(), View_Song.class);
                intent.putExtra("SONG_NAME", FAKE_SONGS[position]);
                intent.putExtra("BAND_NAME", FAKE_BANDS[position]);
                startActivity(intent);
            }
        });

        update = (SwipeRefreshLayout) view.findViewById(R.id.update);
        update.setOnRefreshListener(this);

        return view;
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


    @Override //при обновлении
    public void onRefresh() {
        FAKE_SONGS[0] = FAKE_SONGS[0] + "0";
        list_adapter = new ListViewAdapter(getActivity(), FAKE_SONGS, FAKE_BANDS);
        AddedSongs.setAdapter(list_adapter); //настраиваем

        update.setRefreshing(false);
    }

}
