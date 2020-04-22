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





        ImageView mainDishes= (ImageView)findViewById(R.id.MainDishes);
        mainDishes.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MainActivity.this, mainDishes.class);
                startActivity(contactIntent);
            }
        });
    }
}