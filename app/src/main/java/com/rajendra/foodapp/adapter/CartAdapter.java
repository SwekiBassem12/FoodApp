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
import com.rajendra.foodapp.model.Cart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    ArrayList<Cart> cartList;

    public CartAdapter(Context context, ArrayList<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_recycler_view_single_row, parent, false);
        CartViewHolder CartViewHolder = new CartViewHolder(view);

        return CartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder,final int position) {
        holder.itemname.setText(cartList.get(position).getItem_name());
        holder.itemprice.setText("DT "+cartList.get(position).getItem_price());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allmenuList.get(position).getName());
                i.putExtra("price", allmenuList.get(position).getPrice());
                i.putExtra("rating", allmenuList.get(position).getRating());
                i.putExtra("image", allmenuList.get(position).getImageUrl());

                context.startActivity(i);*/
            }
        });


    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView itemname, itemprice,delete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.OrderItem);
            itemprice = itemView.findViewById(R.id.ItemPrice);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
