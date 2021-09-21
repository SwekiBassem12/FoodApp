package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.foodapp.FoodDetails;
import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.Allmenu;
import com.rajendra.foodapp.model.Popular;

import java.util.ArrayList;

public class PopAdapter extends RecyclerView.Adapter<PopAdapter.BarsViewHolder> {
    Context context;
    ArrayList<Popular> allmenuList;

    public PopAdapter(Context context, ArrayList<Popular> allmenuList) {
        this.context = context;
        this.allmenuList = allmenuList;
    }

    @NonNull
    @Override
    public BarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);
        BarsViewHolder BarsViewHolder = new BarsViewHolder(view);

        return BarsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BarsViewHolder holder,final int position) {
        holder.allMenuName.setText(allmenuList.get(position).getName());


        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.allMenuImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allmenuList.get(position).getName());
                i.putExtra("price", allmenuList.get(position).getPrice());
                i.putExtra("rating", allmenuList.get(position).getRating());
                i.putExtra("image", allmenuList.get(position).getImageUrl());

                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return allmenuList.size();
    }

    public static class BarsViewHolder extends RecyclerView.ViewHolder {
        TextView allMenuName, allMenuNote, allMenuRating, allMenuTime, allMenuCharges, allMenuPrice;
        ImageView allMenuImage;

        public BarsViewHolder(@NonNull View itemView) {
            super(itemView);

            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuNote = itemView.findViewById(R.id.all_menu_note);
            allMenuCharges = itemView.findViewById(R.id.all_menu_delivery_charge);
            allMenuRating = itemView.findViewById(R.id.all_menu_rating);
            allMenuTime = itemView.findViewById(R.id.all_menu_deliverytime);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
        }
    }
}
