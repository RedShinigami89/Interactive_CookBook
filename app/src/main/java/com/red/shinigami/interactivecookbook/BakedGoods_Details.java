package com.red.shinigami.interactivecookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BakedGoods_Details extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baked_goods__details);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        VideoViewIniate();

        Intent intent = getIntent();
        Baking_Model baked = intent.getParcelableExtra("baked");
        final  String name = baked.getmName();
        BakedGoods_Details.this.setTitle(name);









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
        final TextView Ingredient10 = findViewById(R.id.ingredient10);
        final TextView Ingredient11 = findViewById(R.id.ingredient11);
        final TextView Ingredient12 = findViewById(R.id.ingredient12);
        final TextView Ingredient13 = findViewById(R.id.ingredient13);
        final TextView Ingredient14 = findViewById(R.id.ingredient14);
        final TextView Ingredient15 = findViewById(R.id.ingredient15);
        final TextView Ingredient16 = findViewById(R.id.ingredient16);
        final TextView Ingredient17 = findViewById(R.id.ingredient17);
        final TextView Ingredient18 = findViewById(R.id.ingredient18);
        final TextView Ingredient19 = findViewById(R.id.ingredient19);
        final TextView Ingredient20 = findViewById(R.id.ingredient20);

        final TextView steps1 = findViewById(R.id.directions1);
        final TextView steps2 = findViewById(R.id.directions2);
        final TextView steps3 = findViewById(R.id.directions3);
        final TextView steps4 = findViewById(R.id.directions4);
        final TextView steps5 = findViewById(R.id.directions5);
        final TextView steps6 = findViewById(R.id.directions6);
        final TextView steps7 = findViewById(R.id.directions7);
        final TextView steps8 = findViewById(R.id.directions8);
        final TextView steps9 = findViewById(R.id.directions9);
        final TextView steps10 = findViewById(R.id.directions10);
        final TextView steps11 = findViewById(R.id.directions11);
        final TextView steps12 = findViewById(R.id.directions12);
        final TextView steps13 = findViewById(R.id.directions13);
        final TextView steps14 = findViewById(R.id.directions14);
        final TextView steps15 = findViewById(R.id.directions15);
        final TextView steps16 = findViewById(R.id.directions16);
        final TextView steps17 = findViewById(R.id.directions17);
        final TextView steps18 = findViewById(R.id.directions18);

        final TextView prep = findViewById(R.id.prep2);
        final TextView cook = findViewById(R.id.cook2);
        final TextView total = findViewById(R.id.total2);
        final TextView Serving = findViewById(R.id.serving2);

        final ImageView HeaderImage = findViewById(R.id.Image);


        String url = "https://api.npoint.io/891d83b380c01c581ed8";

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
                                String ingredient6 = object.getString("Ingredient6");
                                String ingredient7 = object.getString("Ingredient7");
                                String ingredient8 = object.getString("Ingredient8");
                                String ingredient9 = object.getString("Ingredient9");
                                String ingredient10 = object.getString("Ingredient10");
                                String ingredient11 = object.getString("Ingredient11");
                                String ingredient12 = object.getString("Ingredient12");
                                String ingredient13 = object.getString("Ingredient13");
                                String ingredient14 = object.getString("Ingredient14");
                                String ingredient15 = object.getString("Ingredient15");
                                String ingredient16 = object.getString("Ingredient16");
                                String ingredient17 = object.getString("Ingredient17");
                                String ingredient18 = object.getString("Ingredient18");
                                String ingredient19 = object.getString("Ingredient19");
                                String ingredient20 = object.getString("Ingredient20");
                                String Steps1 = object.getString("Steps1");
                                String Steps2 = object.getString("Steps2");
                                String Steps3 = object.getString("Steps3");
                                String Steps4 = object.getString("Steps4");
                                String Steps5 = object.getString("Steps5");
                                String Steps6 = object.getString("Steps6");
                                String Steps7 = object.getString("Steps7");
                                String Steps8 = object.getString("Steps8");
                                String Steps9 = object.getString("Steps9");
                                String Steps10 = object.getString("Steps10");
                                String Steps11 = object.getString("Steps11");
                                String Steps12 = object.getString("Steps12");
                                String Steps13 = object.getString("Steps13");
                                String Steps14 = object.getString("Steps14");
                                String Steps15 = object.getString("Steps15");
                                String Steps16 = object.getString("Steps16");
                                String Steps17 = object.getString("Steps17");
                                String Steps18 = object.getString("Steps18");
                                String PrepTime = object.getString("PrepTime");
                                String CookTime = object.getString("CookTime");
                                String TotalTime = object.getString("TotalTime");
                                String servings = object.getString("Serving");
                                String URL = object.getString("ImageURL1");



                                Title.setText(title);
                                Ingredient1.setText(ingredient1);
                                Ingredient2.setText(ingredient2);
                                Ingredient3.setText(ingredient3);
                                Ingredient4.setText(ingredient4);
                                Ingredient5.setText(ingredient5);
                                Ingredient6.setText(ingredient6);
                                Ingredient7.setText(ingredient7);
                                Ingredient8.setText(ingredient8);
                                Ingredient9.setText(ingredient9);
                                Ingredient10.setText(ingredient10);
                                Ingredient11.setText(ingredient11);
                                Ingredient12.setText(ingredient12);
                                Ingredient13.setText(ingredient13);
                                Ingredient14.setText(ingredient14);
                                Ingredient15.setText(ingredient15);
                                Ingredient16.setText(ingredient16);
                                Ingredient17.setText(ingredient17);
                                Ingredient18.setText(ingredient18);
                                Ingredient19.setText(ingredient19);
                                Ingredient20.setText(ingredient20);
                                steps1.setText(Steps1);
                                steps2.setText(Steps2);
                                steps3.setText(Steps3);
                                steps4.setText(Steps4);
                                steps5.setText(Steps5);
                                steps6.setText(Steps6);
                                steps7.setText(Steps7);
                                steps8.setText(Steps8);
                                steps9.setText(Steps9);
                                steps10.setText(Steps10);
                                steps11.setText(Steps11);
                                steps12.setText(Steps12);
                                steps13.setText(Steps13);
                                steps14.setText(Steps14);
                                steps15.setText(Steps15);
                                steps16.setText(Steps16);
                                steps17.setText(Steps17);
                                steps18.setText(Steps18);

                                prep.setText(PrepTime);
                                cook.setText(CookTime);
                                total.setText(TotalTime);
                                Serving.setText(servings);


                                Glide.with(BakedGoods_Details.this).load(URL).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(HeaderImage);




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




    }
    public void VideoViewIniate(){
        VideoView Vid = findViewById(R.id.VideoView1);
        ImageView Error = findViewById(R.id.ImageViewError);
        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");
        String YTURL = "";

        if (YTURL.contains(".mp4")) {

            Vid.setVideoURI(Uri.parse(YTURL));
            Vid.start();
        }else{
            Error.setVisibility(View.VISIBLE);
            Vid.setVisibility(View.GONE);
        }
    }

}
