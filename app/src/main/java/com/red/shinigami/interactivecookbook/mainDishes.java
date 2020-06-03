package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import androidx.appcompat.widget.SearchView;

public class mainDishes extends AppCompatActivity {
    adapter adapter;
    private ArrayList<Recipes> recipes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mainDishes.this.setTitle("Entree's");
        recipes = new ArrayList<>();
        ParseJSON();


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void ParseJSON(){

        String url = "https://api.npoint.io/e01a7a10d10c838c5e05";

         JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray JA = response.getJSONArray("entree"); //gets array information based on which contact was clicked via variable name
                            for (int i = 0; i < JA.length(); i++) {
                                JSONObject object = JA.getJSONObject(i);
                                String recipeName = object.getString("name");
                                String PrepTime = object.getString("prep");
                                String CookTime = object.getString("cook");
                                String TotalTime = object.getString("total");
                                String recipeImage = object.getString("image");


                                recipes.add(new Recipes(recipeName, recipeImage, PrepTime, CookTime, TotalTime, ""));


                            }

                            RecyclerView recyclerView = findViewById(R.id.rv);
                            final adapter mAdapter = new adapter(mainDishes.this, recipes);
                            recyclerView.setAdapter(mAdapter);


                            mAdapter.setOnItemClickListener(new adapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    changeItem(position);
                                    ImageView imageView = findViewById(R.id.sampleImage);
                                    Intent intent = new Intent(mainDishes.this, PorkChops_Activity.class);
                                    intent.putExtra("recipe loader", recipes.get(position));
                                    intent.putExtra("YTURL", recipes.get(position));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        adapter = new adapter(mainDishes.this, recipes);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return true;
    }

       public void changeItem(int position){
            recipes.get(position);
        }

    }






