package com.red.shinigami.interactivecookbook;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class mainDishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);

        ArrayList<Recipes> recipes = new ArrayList<>();
        recipes.add(new Recipes("Honey Garlic Pork Chops", R.drawable.porkchops, "10 mins", "15 mins", "25 mins"));
        recipes.add(new Recipes("Classic Burger", R.drawable.classic_burger, "10 mins", "8 mins", "18 mins"));
        recipes.add(new Recipes("Steak", R.drawable.ic_salad, "0", "0", "0"));
        recipes.add(new Recipes("Steak", R.drawable.ic_cake, "0", "0", "0"));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter mAdapter = new adapter(recipes);
        recyclerView.setAdapter(mAdapter);
        
    }


}
