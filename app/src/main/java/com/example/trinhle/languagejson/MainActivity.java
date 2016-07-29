package com.example.trinhle.languagejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trinhle.languagejson.adapter.RecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private RecyclerView rvCategory;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        rvCategory.setLayoutManager(layoutManager);
        requestJSONCategory();
    }

    private void requestJSONCategory() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://sflashcard.com/service/category/get";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response" + response);
                GsonBuilder builder = new GsonBuilder();
                Gson categoryGSON = builder.create();
                List<Category> categoryList = new ArrayList<Category>();
                categoryList = Arrays.asList(categoryGSON.fromJson(response, Category[].class));
                adapter = new RecyclerViewAdapter(MainActivity.this, categoryList);
                rvCategory.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error" + error.getMessage());
            }
        });
        queue.add(request);
    }
}
