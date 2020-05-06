package com.red.shinigami.interactivecookbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        final VideoView VidView1 = findViewById(R.id.VideoView1);
        ImageView error = findViewById(R.id.ImageViewError);

        Intent intent = getIntent();
        Recipes recipes = intent.getParcelableExtra("recipe loader");


        LinearLayout lLayout = findViewById(R.id.linearLayout);
        ImageView imageView = findViewById(R.id.Image);

       String vid = recipes.getmYTURL();
        MediaController mMedia = new MediaController(PorkChops_Activity.this);

        TextView RecipeTitle = findViewById(R.id.recipeTitle);
        int updateTitle = recipes.getmrecipeName();
        RecipeTitle.setText(updateTitle);
        String imageUrl = recipes.getmRecipeImages();

        if(vid.contains("brightcove.net")){
            VidView1.setVisibility(VideoView.GONE);
            error.setVisibility(ImageView.VISIBLE);
        }else {
            Uri vidUri = Uri.parse(vid);
            VidView1.setVideoURI(vidUri);
            VidView1.setMediaController(mMedia);
            mMedia.setAnchorView(VidView1);
            VidView1.start();
        }






        Glide.with(this).load(imageUrl).centerCrop().error(R.drawable.ic_error).into(imageView);


     



       //Ingrident list
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



    }





}
