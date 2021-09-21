
package com.rajendra.foodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cart {

    @SerializedName("item_name")
    @Expose
    private String item_name;
    @SerializedName("item_price")
    @Expose
    private String item_price;
    @SerializedName("user_name")
    @Expose
    private String user_name;

    public Cart(String item_name, String item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
