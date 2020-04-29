package com.red.shinigami.interactivecookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PorkChops_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porkchops);

        TextView mTextView = findViewById(R.id.ingredient1);
        TextView mIngredient2 = findViewById(R.id.ingredient2);
        TextView mIngredient3 = findViewById(R.id.ingredient3);
        TextView mIngredient4 = findViewById(R.id.ingredient4);
        TextView mIngredient5 = findViewById(R.id.ingredient5);
        String firstIngredient = getString(R.string.half) + " " + getString(R.string.cup) + " - " + getString(R.string.ketchup);
        String secondIngredient = 2 + " " + getString(R.string.twoThird) + " " + getString(R.string.Tablespoon) + " - " + getString(R.string.honey);
        String thirdIngredient = 2 + " " + getString(R.string.Tablespoon) + " - " + getString(R.string.soy);
        String fourthIngredient = 2 + " " + getString(R.string.clove) + " " + getString(R.string.garlic) + " crushed";
        String fifthIngredient = 6 + " 4 ounces " + getString(R.string.pork);

        mIngredient2.setText(secondIngredient);
        mIngredient3.setText(thirdIngredient);
        mTextView.setText(firstIngredient);
        mIngredient4.setText(fourthIngredient);
        mIngredient5.setText(fifthIngredient);

        ImageView imageView = findViewById(R.id.Image);
        String imageUrl = "https://i.imgur.com/ks3xoD6.jpg";
        //Loading image using Picasso
        new DownLoadImageTask(imageView).execute(imageUrl);
    }



}
