package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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

import java.util.ArrayList;

public class BarsAdapter extends RecyclerView.Adapter<com.rajendra.foodapp.adapter.BarsAdapter.BarsViewHolder> {
    Context context;
    ArrayList<Allmenu> allmenuList;

    public BarsAdapter(Context context, ArrayList<Allmenu> allmenuList) {
        this.context = context;
        this.allmenuList = allmenuList;
    }

    @NonNull
    @Override
    public BarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);
        BarsViewHolder BarsViewHolder = new BarsViewHolder(view);

        return BarsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BarsViewHolder holder, final int position) {
        holder.allMenuName.setText(allmenuList.get(position).getName());
        holder.allMenuPrice.setText(allmenuList.get(position).getPrice());
        holder.allMenuTime.setText(allmenuList.get(position).getDeliveryTime());
        holder.allMenuRating.setText(allmenuList.get(position).getRating());
        holder.allMenuCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.allMenuNote.setText(allmenuList.get(position).getNote());

        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.allMenuImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.allMenuImage.buildDrawingCache();
                Bitmap image= holder.allMenuImage.getDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putString("name", allmenuList.get(position).getName());
                extras.putString("price", allmenuList.get(position).getPrice());
                extras.putString("rating", allmenuList.get(position).getRating());
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtras(extras);
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
