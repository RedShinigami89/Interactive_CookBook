package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView drinks = findViewById(R.id.cocktail);
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MainActivity.this, Drinks1.class);
                startActivity(contactIntent);
            }
        });


        ImageView mainDishes= findViewById(R.id.MainDishes);
        mainDishes.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MainActivity.this, mainDishes.class);
                startActivity(contactIntent);
            }
        });

        ImageView BakedGoods = findViewById(R.id.cake);
        BakedGoods.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MainActivity.this, baked_goods.class);
                startActivity(contactIntent);
            }
        });
    }
}
