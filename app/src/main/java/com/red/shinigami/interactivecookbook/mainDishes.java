package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class mainDishes extends AppCompatActivity{

    private ArrayList<Recipes> recipes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);
        createRecipes();


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final adapter mAdapter = new adapter(recipes);
        recyclerView.setAdapter(mAdapter);






        mAdapter.setOnItemClickListener(new adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position);
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                      Intent intent = new Intent(mainDishes.this, PorkChops_Activity.class);
                      intent.putExtra("recipe loader", recipes.get(position));
                      intent.putExtra("YTURL", recipes.get(position));
                      startActivity(intent);
                        break;

                }
                mAdapter.notifyItemChanged(position);
            }
        });


        }

        public void createRecipes(){
            recipes = new ArrayList<>();
            recipes.add(new Recipes(R.string.Porkchops,"https://i.imgur.com/ks3xoD6.jpg" ,"10 mins", "15 mins", "25 mins","https://players.brightcove.net/1033249144001/HyUr5pA17_default/index.html?videoId=5798846980001"));
            recipes.add(new Recipes(R.string.burger,"https://i.imgur.com/g1YpBYB.jpg","10 mins", "8 mins", "18 mins", "https://content.jwplatform.com/videos/N6FmdHp7.mp4"));
            recipes.add(new Recipes(R.string.tikka,"https://i.imgur.com/2tWvs4y.jpg", "30 Mins", "50 mins", "2hrs 20 mins",""));
            recipes.add(new Recipes(R.string.Missing, "https://media.giphy.com/media/YRo59AZhP7ngvndDul/giphy.gif", "0", "0", "0", ""));
            recipes.add(new Recipes(R.string.Ginger_Beef, "https://i.imgur.com/RHh7eTP.jpg", "25 mins", "20 mins", "45 mins", ""));


        }




       public void changeItem(int position){
            recipes.get(position);
        }






    }






