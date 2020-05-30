package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class testing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_activity);

        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");
      final  String name = recipes.getmrecipeName();


        String url = "https://api.npoint.io/11990ece203fd1b2c219";

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView Testing = findViewById(R.id.textViewTesting);
                        try {

                            JSONObject twitchOnline = response;
                            JSONArray JA = twitchOnline.getJSONArray(name);
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject object = JA.getJSONObject(i);
                                String bio = object.getString("RecipeTitle");
                                Testing.setText(bio);
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
        MySingleton.getInstance(testing_activity.this.getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }

}
