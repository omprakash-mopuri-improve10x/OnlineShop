package com.omprakash.onlineshopping.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingApi {

    public ShoppingService createShoppingService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kisanmart.co/kisanmart/app/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShoppingService shoppingService = retrofit.create(ShoppingService.class);
        return shoppingService;
    }
}
