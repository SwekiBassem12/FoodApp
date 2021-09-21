package com.rajendra.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.rajendra.foodapp.adapter.AllMenuAdapter;
import com.rajendra.foodapp.adapter.BarsAdapter;
import com.rajendra.foodapp.adapter.PopAdapter;
import com.rajendra.foodapp.adapter.PopularAdapter;
import com.rajendra.foodapp.model.Allmenu;
import com.rajendra.foodapp.model.Popular;
import com.rajendra.foodapp.retrofit.ApiInterface;
import com.rajendra.foodapp.retrofit.RetrofitClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    static final float END_SCALE = 0.7f;
    RecyclerView popularRecyclerView, allMenuRecyclerView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    PopularAdapter popularAdapter;
    AllMenuAdapter allMenuAdapter;
    BarsAdapter barsAdapter;
    PopAdapter adapter;
    ConstraintLayout contentView;
    ImageView icon_drawer,cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        contentView = findViewById(R.id.content);
        icon_drawer = findViewById(R.id.menu_icon);
        cart = findViewById(R.id.cart);

        navigationDrawer();
        getAllMenu();
        getPopularData();


      cart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(MainActivity.this,Cart.class);
              startActivity(i);
          }
      });
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);
        icon_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNagivationDrawer();
    }

    private void animateNagivationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.card1));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    private void  getPopularData(){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        ArrayList<Popular> Al = new ArrayList<>();
        Al.add(new Popular("Crepe",R.drawable.crepe,"4.0","30 min","6 DT","9 DT","Come take it"));
        Al.add(new Popular("Pizza",R.drawable.pizza,"4.0","30 min","6 DT","9 DT","Come take it"));
        Al.add(new Popular("Gauffre",R.drawable.gauffre,"4.0","30 min","6 DT","9 DT","Come take it"));
        Al.add(new Popular("Sandwich",R.drawable.sndwich,"4.0","30 min","6 DT","9 DT","Come take it"));
        Al.add(new Popular("Salade",R.drawable.salade1,"4.0","30 min","6 DT","9 DT","Come take it"));
        adapter = new PopAdapter(this, Al);
        popularRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void  getAllMenu(){
        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        ArrayList<Allmenu> All = new ArrayList<>();
        All.add(new Allmenu("Crepe",R.drawable.asiafood1,"4.0","30 min","6 DT","9 DT","Come take it"));
        All.add(new Allmenu("Haja okhra",R.drawable.asiafood2,"4.0","30 min","6 DT","15 DT","Come take it"));
        All.add(new Allmenu("HHHHHH",R.drawable.popular1,"4.0","30 min","6 DT","10 DT","Come take it"));
        All.add(new Allmenu("PPPPSSSS",R.drawable.popularfood2,"4.0","30 min","6 DT","12 DT","Come take it"));
        All.add(new Allmenu("PPPPSSSS",R.drawable.popularfood3,"4.0","30 min","6 DT","20 DT","Come take it"));
        barsAdapter = new BarsAdapter(this, All);
        allMenuRecyclerView.setAdapter(barsAdapter);
        barsAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(MainActivity.this, Update_profile.class);
                startActivity(i);
                break;
            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.near_by:
                Intent intent = null, chooser = null;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:36.845170,11.080392"));
                chooser = Intent.createChooser(intent, "Launch Maps");
                startActivity(chooser);
                break;
            case R.id.fav:
                Intent a = new Intent(MainActivity.this, Favoris.class);
                startActivity(a);
                break;
        }
        return true;
    }
}
