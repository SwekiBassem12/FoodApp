package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rajendra.foodapp.adapter.CartAdapter;
import com.rajendra.foodapp.adapter.PopAdapter;
import com.rajendra.foodapp.model.Popular;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
RecyclerView cartRecycler;
CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
getCartData();
    }

    private void  getCartData(){

        cartRecycler = findViewById(R.id.recyclerViewCart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        ArrayList<com.rajendra.foodapp.model.Cart> Al = new ArrayList<>();
        Al.add(new com.rajendra.foodapp.model.Cart("crepe","16"));
        Al.add(new com.rajendra.foodapp.model.Cart("pizza","20"));
        Al.add(new com.rajendra.foodapp.model.Cart("sandwich","9"));
        cartAdapter = new CartAdapter(this, Al);
        cartRecycler.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

    }
}