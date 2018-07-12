package com.example.hp.newsapi;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.networkutil.NetworkUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    String id;
    String API_KEY = "57e1226a0c39449aace56653a91866b4";
    String BASE_URL = "https://newsapi.org/v2/top-headlines?sources=";

    String data;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);

        recyclerView = findViewById (R.id.detailList);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));

        Intent intent = getIntent ();

        id = intent.getStringExtra ("id");

        adapter = new Adapter (this);
        recyclerView.setAdapter (adapter);
        new FetchNews ().execute ();

    }

    class FetchNews extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            String finalUrl = BASE_URL + id + "&apiKey=57e1226a0c39449aace56653a91866b4";

            data = NetworkUtil.makeServiceCall (finalUrl);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute (aVoid);
            ArrayList<News> newsArrayList = new ArrayList<> ();
            if (data == null) {
                Toast.makeText (Main2Activity.this, "No data returned", Toast.LENGTH_SHORT).show ();
            } else {
                try {
                    JSONObject jsonData = new JSONObject (data);
                    JSONArray articalArray = jsonData.getJSONArray ("articles");

                    for (int i = 0; i < articalArray.length (); i++) {

                        JSONObject news = articalArray.getJSONObject (i);

                        String title = news.getString ("title");
                        String description = news.getString ("description");
                        String imageUrl = news.getString ("urlToImage");

                        newsArrayList.add (new News (title, description, imageUrl));

                    }

                } catch (JSONException e) {
                    e.printStackTrace ();
                }
            }

            adapter.swap (newsArrayList);

        }
    }
}
