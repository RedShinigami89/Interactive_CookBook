package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PorkChops_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porkchops);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");
        final  String name = getString(recipes.getmrecipeName());
        final String imageUrl = recipes.getmRecipeImages();
        PorkChops_Activity.this.setTitle(name);
        final TextView Title = findViewById(R.id.recipeTitle);
        final TextView Ingredient1 = findViewById(R.id.ingredient1);
        final TextView Ingredient2 = findViewById(R.id.ingredient2);
        final TextView Ingredient3 = findViewById(R.id.ingredient3);
        final TextView Ingredient4 = findViewById(R.id.ingredient4);
        final TextView Ingredient5 = findViewById(R.id.ingredient5);
        final TextView Ingredient6 = findViewById(R.id.ingredient6);
        final TextView Ingredient7 = findViewById(R.id.ingredient7);
        final TextView Ingredient8 = findViewById(R.id.ingredient8);
        final TextView Ingredient9 = findViewById(R.id.ingredient9);
        final ImageView HeaderImage = findViewById(R.id.Image);
        Glide.with(this).load(imageUrl).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(HeaderImage);



        String url = "https://api.npoint.io/11990ece203fd1b2c219";

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray JA = response.getJSONArray(name); //gets array information based on which contact was clicked via variable name
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject object = JA.getJSONObject(i);
                                String title = object.getString("RecipeTitle"); //from the object in the array above
                                String ingredient1 = object.getString("Ingredient1");
                                String ingredient2 = object.getString("Ingredient2");
                                String ingredient3 = object.getString("Ingredient3");
                                String ingredient4 = object.getString("Ingredient4");
                                String ingredient5 = object.getString("Ingredient5");
                               // String ingredient6 = object.getString("Ingredient6");
                               // String ingredient7 = object.getString("Ingredient7");
                                Title.setText(title);
                                Ingredient1.setText(ingredient1);//set text of ingredient 1 of json file
                                Ingredient1.setVisibility(View.VISIBLE);//makes the textview visible 
                                Ingredient2.setText(ingredient2);
                                Ingredient2.setVisibility(View.VISIBLE);
                                Ingredient3.setText(ingredient3);
                                Ingredient3.setVisibility(View.VISIBLE);
                                Ingredient4.setText(ingredient4);
                                Ingredient4.setVisibility(View.VISIBLE);
                                Ingredient5.setText(ingredient5);
                                Ingredient5.setVisibility(View.VISIBLE);
                               // Ingredient6.setText(ingredient6);
                               // Ingredient6.setVisibility(View.VISIBLE);

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                }


                        , new Response.ErrorListener()


                {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY", "ERROR");

                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        Glide.with(this).load(imageUrl).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(HeaderImage);


    }

    }


