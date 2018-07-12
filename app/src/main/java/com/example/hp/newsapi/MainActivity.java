package com.example.hp.newsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        listView = findViewById (R.id.listitem);

        String[] channelName = {"ABC News","The Times Of India","National Geographic"};
        final String[] channelID = {"abc-news","the-times-of-india","national-geographic"};

        ArrayAdapter<String> adapter = new ArrayAdapter<> (this,android.R.layout.simple_dropdown_item_1line,channelName);
        listView.setAdapter (adapter);

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String chid = channelID[position];

                Intent intent = new Intent (MainActivity.this,Main2Activity.class);

                intent.putExtra("id",chid);
                startActivity (intent);
            }
        });


    }

}
