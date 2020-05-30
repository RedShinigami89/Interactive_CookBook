package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class drinkContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_contact);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setContent();

    }


    public void setContent(){
        Intent intent = getIntent();
        drinks recipes = intent.getParcelableExtra("Drink Loader");

        //calling parcelable texts
        final String drink = recipes.getmDrinksTitle();
        final String imageURL = recipes.getmDrinksImage();
        final String drinkIngredient1 = recipes.getmDrinksIngredient1();
        final String drinkIngredient2 = recipes.getmDrinksIngredient2();
        final String drinkIngredient3 = recipes.getmDrinksIngredient3();
        final String drinkSteps1 = recipes.getmSteps1();
        final String drinkSteps2 = recipes.getmSteps2();

        //Init Views
        final TextView DrinkTitle = findViewById(R.id.drinkTitle);
        final ImageView DrinkImage = findViewById(R.id.drinkImage);
        final TextView Ingredient1 = findViewById(R.id.drinkIngredient1);
        final TextView Ingredient2 = findViewById(R.id.drinkIngredient2);
        final TextView Ingredient3 = findViewById(R.id.drinkIngredient3);
        final TextView step1 = findViewById(R.id.Steps1);
        final TextView step2 = findViewById(R.id.Steps2);

        //Set Text
        drinkContact.this.setTitle(drink);
        DrinkTitle.setText(drink);
        Ingredient1.setText(drinkIngredient1);
        Ingredient2.setText(drinkIngredient2);
        Ingredient3.setText(drinkIngredient3);
        step1.setText(drinkSteps1);
        step2.setText(drinkSteps2);

        //Init Photos
        Glide.with(this).load(imageURL).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(DrinkImage);
    }
}

