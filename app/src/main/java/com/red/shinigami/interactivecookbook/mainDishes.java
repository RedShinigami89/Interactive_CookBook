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
                Intent intent = null;
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        intent = new Intent(mainDishes.this, PorkChops_Activity.class);
                        break;

                }
                startActivity(intent);
                mAdapter.notifyItemChanged(position);
            }
        });


        }

        public void createRecipes(){
            recipes = new ArrayList<>();
            recipes.add(new Recipes("Honey Garlic Pork Chops", R.drawable.porkchops, "10 mins", "15 mins", "25 mins"));
            recipes.add(new Recipes("Classic Burger", R.drawable.classic_burger, "10 mins", "8 mins", "18 mins"));
            recipes.add(new Recipes("Steak", R.drawable.ic_salad, "0", "0", "0"));
            recipes.add(new Recipes("Steak", R.drawable.ic_cake, "0", "0", "0"));


        }

        public void changeItem(int position){
            recipes.get(position);
        }


    }






