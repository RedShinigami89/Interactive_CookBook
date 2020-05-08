package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;



public class PorkChops_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porkchops);
        ingredientList();

        VideoView VidView1 = findViewById(R.id.VideoView1);
        ImageView error = findViewById(R.id.ImageViewError);
        ImageView imageView = findViewById(R.id.Image);
        TextView prep = findViewById(R.id.prep2);
        TextView cook = findViewById(R.id.cook2);
        TextView total = findViewById(R.id.total2);
        TextView RecipeTitle = findViewById(R.id.recipeTitle);




        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");

        MediaController mMedia = new MediaController(PorkChops_Activity.this);

        String vid = recipes.getmYTURL();
        String prepText = recipes.getmPrepTime();
        String cookText = recipes.getmCookTime();
        String totalText = recipes.getmTotalTime();

        int updateTitle = recipes.getmrecipeName();
        RecipeTitle.setText(updateTitle);
        prep.setText(prepText);
        cook.setText(cookText);
        total.setText(totalText);
        String imageUrl = recipes.getmRecipeImages();

        if(vid.contains("brightcove.net")) {
            VidView1.setVisibility(VideoView.GONE);
            error.setVisibility(ImageView.VISIBLE);

        }if(vid.equals("")){
            VidView1.setVisibility(VideoView.GONE);
            error.setVisibility(ImageView.VISIBLE);

        }else {
            Uri vidUri = Uri.parse(vid);
            VidView1.setVideoURI(vidUri);
            VidView1.setMediaController(mMedia);
            mMedia.setAnchorView(VidView1);
            VidView1.start();
        }

        Glide.with(this).load(imageUrl).centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error).into(imageView);

    }

    //Ingredient List
    String Ingredient1;
    String Ingredient2;
    String Ingredient3;
    String Ingredient4;
    String Ingredient5;
    String Ingredient6;
    String Ingredient7;
    String Ingredient8;
    String Ingredient9;
    String Ingredient10;
    String Ingredient11;
    String Ingredient12;
    String Ingredient13;
    String Ingredient14;
    String Ingredient15;
    String Ingredient16;
    String Ingredient17;
    String Ingredient18;
    String Ingredient19;
    String Ingredient20;





    public void ingredientList() {


        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");
        String Title = getString(recipes.getmrecipeName());



          if (Title.contains("Honey Garlic")) {
        Ingredient1 = getString(R.string.half) + " " + getString(R.string.cup) + " " + getString(R.string.ketchup);
        Ingredient2 = getString(R.string.two) + " " + getString(R.string.twoThird) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.honey);
        Ingredient3 = getString(R.string.two) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.soy);
        Ingredient4 = getString(R.string.two) + " " + getString(R.string.clove) + " " + getString(R.string.garlic) + " " + getString(R.string.crush);
        Ingredient5 = getString(R.string.six) + " " + getString(R.string.pork);
        SetIngredientList();
          }if(Title.contains("Classic Burger")){
          Ingredient1 = getString(R.string.one) + " " + getString(R.string.half) + " " + getString(R.string.pound) + " " + getString(R.string.leanBeef);
          Ingredient2 = getString(R.string.one) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.Worcestershire);
          Ingredient3 = getString(R.string.one) + " " + getString(R.string.half) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.seasoning);
          Ingredient4 = getString(R.string.one) + " " + getString(R.string.teaspoon) + " " + getString(R.string.garlicPowder);
          Ingredient5 = getString(R.string.half) + " " + getString(R.string.teaspoon) + " " + getString(R.string.pepper);
          Ingredient6 = getString(R.string.four) + " " + getString(R.string.slice);
          Ingredient7 = getString(R.string.four) + " " + getString(R.string.hamburgerBun);
               SetIngredientList();
          }if(Title.contains("Tikka Masala")){
          Ingredient1 = getString(R.string.one) + " " + getString(R.string.cup) + " " + getString(R.string.yogurt);
          Ingredient2 = getString(R.string.one) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.lemon);
          Ingredient3 = getString(R.string.two) + " " + getString(R.string.teaspoon) + " " + getString(R.string.cumin);
          Ingredient4 = getString(R.string.one) + " " + getString(R.string.teaspoon) + " " + getString(R.string.cinnamon);
          Ingredient5 = getString(R.string.two) + " " + getString(R.string.teaspoon) + " " + getString(R.string.cayenne);
          Ingredient6 = getString(R.string.two) + " " + getString(R.string.teaspoon) + " " + getString(R.string.pepper);
          Ingredient7 = getString(R.string.one) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.ginger);
          Ingredient8 = getString(R.string.one) + " " + getString(R.string.teaspoon) + " " + getString(R.string.salt);
          Ingredient9 = getString(R.string.three) + " " + getString(R.string.boneless) + " " + getString(R.string.chicken);
          Ingredient10 = getString(R.string.four) + " " + getString(R.string.skewers);
          Ingredient11 = getString(R.string.one) + " " + getString(R.string.Tablespoon) + " " + getString(R.string.butter);
          Ingredient12 = getString(R.string.one) + " " + getString(R.string.clove) + " " + getString(R.string.garlic) + " " + getString(R.string.mince);
          Ingredient13 = getString(R.string.one) + " " + getString(R.string.jalapeno) + " " + getString(R.string.chop);
          Ingredient14 = getString(R.string.two) + " " + getString(R.string.teaspoon) + " " + getString(R.string.cumin);
          Ingredient15 = getString(R.string.two) + " " + getString(R.string.teaspoon) + " " + getString(R.string.paprika);
          Ingredient16 = getString(R.string.one) + " " + getString(R.string.teaspoon) + " " + getString(R.string.salt);
          Ingredient17 = getString(R.string.one) + " " + getString(R.string.can) + " " + getString(R.string.tomatosauce);
          Ingredient18 = getString(R.string.one) + " " + getString(R.string.cup) + " " + getString(R.string.cream);
          Ingredient19 = getString(R.string.quarter) + " "  + getString(R.string.cup) + " " + getString(R.string.chop) + " " + getString(R.string.cilantro);
           SetIngredientList();
        }


    }

    public void SetIngredientList(){
        //Ingrident View list
        TextView mTextView = findViewById(R.id.ingredient1);
        TextView mIngredient2 = findViewById(R.id.ingredient2);
        TextView mIngredient3 = findViewById(R.id.ingredient3);
        TextView mIngredient4 = findViewById(R.id.ingredient4);
        TextView mIngredient5 = findViewById(R.id.ingredient5);
        TextView mIngredient6 = findViewById(R.id.ingredient6);
        TextView mIngredient7 = findViewById(R.id.ingredient7);
        TextView mIngredient8 = findViewById(R.id.ingredient8);
        TextView mIngredient9 = findViewById(R.id.ingredient9);
        TextView mIngredient10 = findViewById(R.id.ingredient10);
        TextView mIngredient11 = findViewById(R.id.ingredient11);
        TextView mIngredient12 = findViewById(R.id.ingredient12);
        TextView mIngredient13 = findViewById(R.id.ingredient13);
        TextView mIngredient14 = findViewById(R.id.ingredient14);
        TextView mIngredient15 = findViewById(R.id.ingredient15);
        TextView mIngredient16 = findViewById(R.id.ingredient16);
        TextView mIngredient17 = findViewById(R.id.ingredient17);
        TextView mIngredient18 = findViewById(R.id.ingredient18);
        TextView mIngredient19 = findViewById(R.id.ingredient19);
        TextView mIngredient20 = findViewById(R.id.ingredient20);




        mTextView.setText(Ingredient1);
        mIngredient2.setText(Ingredient2);
        mIngredient3.setText(Ingredient3);
        mIngredient4.setText(Ingredient4);
        mIngredient5.setText(Ingredient5);
        mIngredient6.setText(Ingredient6);
        mIngredient7.setText(Ingredient7);
        mIngredient8.setText(Ingredient8);
        mIngredient9.setText(Ingredient9);
        mIngredient10.setText(Ingredient10);
        mIngredient11.setText(Ingredient11);
        mIngredient12.setText(Ingredient12);
        mIngredient13.setText(Ingredient13);
        mIngredient14.setText(Ingredient14);
        mIngredient15.setText(Ingredient15);
        mIngredient16.setText(Ingredient16);
        mIngredient17.setText(Ingredient17);
        mIngredient18.setText(Ingredient18);
        mIngredient19.setText(Ingredient19);
        mIngredient20.setText(Ingredient20);

    }








}
