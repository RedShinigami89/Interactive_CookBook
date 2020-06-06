package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class baked_goods extends AppCompatActivity {
    private ArrayList<Baking_Model> BakedGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baked_goods);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        baked_goods.this.setTitle("Baked Goods");
        BakedGoods = new ArrayList<>();
        ParseJSON();
        RecyclerView recyclerView = findViewById(R.id.RV_BakedGoods);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void ParseJSON(){

        String url = "https://api.npoint.io/d26bfdafd6ba68498315";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray JA = response.getJSONArray("Baked"); //gets array information based on which contact was clicked via variable name
                            for (int i = 0; i < JA.length(); i++) {
                                JSONObject object = JA.getJSONObject(i);
                                final String Name = object.getString("name");
                                final String Image = object.getString("image");
                                final String Prep = object.getString("prep");
                                final String Cook = object.getString("cook");
                                final String Time = object.getString("total");
                                BakedGoods.add(new Baking_Model(Name, Image, Prep, Cook, Time));


                            }

                            RecyclerView recyclerView = findViewById(R.id.RV_BakedGoods);
                            final bakingAdapter mAdapter = new bakingAdapter(baked_goods.this, BakedGoods);
                            recyclerView.setAdapter(mAdapter);

                            mAdapter.setOnItemClickListener(new adapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    changeItem(position);
                                    ImageView imageView = findViewById(R.id.sampleImage);
                                    Intent intent = new Intent(baked_goods.this, BakedGoods_Details.class);
                                    intent.putExtra("baked", BakedGoods.get(position));
                                    intent.putExtra("YTURL", BakedGoods.get(position));
                                    startActivity(intent);

                                    mAdapter.notifyItemChanged(position);
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                }


                        , new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");

                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    public void changeItem(int position){
        BakedGoods.get(position);
    }
}
