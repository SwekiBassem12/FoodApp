package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {

    // now we will get data from intent and set to UI

    ImageView imageView,back,shop,fav;
    TextView itemName, itemPrice, itemRating;
    RatingBar ratingBar;

    String name, price, rating, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = extras.getParcelable("imagebitmap");
        String n = extras.getString("name");
        String r = extras.getString("rating");
        String p = extras.getString("price");


        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");

        imageView = findViewById(R.id.imageView5);
        shop = findViewById(R.id.shop2);
        fav = findViewById(R.id.favoris);
        back = findViewById(R.id.imageView2);
        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

       // Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        imageView.setImageBitmap(bmp );
        itemName.setText(n);
        itemPrice.setText(p);
        itemRating.setText(r);
        ratingBar.setRating(Float.parseFloat(rating));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodDetails.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FoodDetails.this,"Article ajouté avec succées",Toast.LENGTH_SHORT).show();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodDetails.this,Cart.class);
                startActivity(i);
            }
        });

    }
}
