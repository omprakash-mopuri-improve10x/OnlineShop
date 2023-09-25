package com.omprakash.onlineshopping.network.model;

import com.google.gson.annotations.SerializedName;

public class WishListResponse {
    private String status;
    private String message;
    @SerializedName("response")
    private WishList wishList;
}
