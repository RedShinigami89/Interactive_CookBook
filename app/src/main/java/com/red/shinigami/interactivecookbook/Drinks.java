package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Drinks extends AppCompatActivity {
    ArrayList<drinks> drinkRecipes;
    drinkAdapter DrinkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        drinkRecipes = new ArrayList<>();
        createDrinks();

        RecyclerView recyclerView = findViewById(R.id.rvDrinks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void changeItem(int position){
        drinkRecipes.get(position);
    }

    public void createDrinks(){

        String url = "https://api.npoint.io/a7f02bd0899734f659a1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray JA = response.getJSONArray("Drinks"); //gets array information based on which contact was clicked via variable name
                            for (int i = 0; i < JA.length(); i++) {
                                JSONObject object = JA.getJSONObject(i);
                               String DrinksTitle =  object.getString("Title");
                               String DrinksImage = object.getString("Image");
                               String Drinks_Description = object.getString("Description");
                               String Ingredient1 = object.getString("Ingredient1");
                               String Ingredient2 = object.getString("Ingredient2");
                               String Ingredient3 = object.getString("Ingredient3");
                               String Step1 = object.getString("Steps1");
                               String Step2 = object.getString("Steps2");

                               drinkRecipes.add(new drinks(DrinksImage, DrinksTitle, Drinks_Description, Ingredient1, Ingredient2, Ingredient3, Step1, Step2));

                            }

                            RecyclerView recyclerView = findViewById(R.id.rvDrinks);
                            final drinkAdapter mdrinkAdapter = new drinkAdapter(Drinks.this, drinkRecipes);
                            recyclerView.setAdapter(mdrinkAdapter);


                            mdrinkAdapter.setOnItemClickListener(new adapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    changeItem(position);
                                    Intent intent = new Intent(Drinks.this, drinkContact.class);
                                    intent.putExtra("Drink Loader", drinkRecipes.get(position));
                                    startActivity(intent);

                                    mdrinkAdapter.notifyItemChanged(position);
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

}
