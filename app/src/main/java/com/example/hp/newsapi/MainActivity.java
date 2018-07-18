package com.example.hp.newsapi;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ItemClick {

    String[] channelID = {"abc-news", "the-times-of-india", "national-geographic", "google-news-in", "news24", "the-new-york-times"};


//    ListView listView;

    RecyclerView recycler;
    CostomAdapter adapter;


//    private ListView mDrawerList;
//    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

//        listView = findViewById (R.id.listitem);

        recycler = findViewById (R.id.chnnlRV);
        recycler.setLayoutManager (new LinearLayoutManager (this));


        adapter = new CostomAdapter (this);
        recycler.setAdapter (adapter);


    }

    @Override
    public void newClick(int position) {

        String chid = channelID[position];
        Intent intent = new Intent (MainActivity.this, Main2Activity.class);
        intent.putExtra ("id", chid);
        startActivity (intent);


    }

}

    ////        mDrawerList = findViewById (R.id.list);
//
//
////        String[] channelName = {"ABC News","The Times Of India","National Geographic","Google News (India)","News24","The New York Times"};
////         String[] channelID = {"abc-news","the-times-of-india","national-geographic","google-news-in","news24","the-new-york-times"};
//
////        ArrayAdapter<String> adapter = new ArrayAdapter<> (this,android.R.layout.simple_dropdown_item_1line,channelName);
//        listView.setAdapter (adapter);

//        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

//                String chid = channelID[position];

//                Intent intent = new Intent (MainActivity.this,Main2Activity.class);

//                intent.putExtra("id",chid);
//                startActivity (intent);
//            }
//        });





