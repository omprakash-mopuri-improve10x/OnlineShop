package com.omprakash.onlineshopping.network;

import com.omprakash.onlineshopping.network.model.CategoryResponse;
import com.omprakash.onlineshopping.network.model.ProductApiResponse;
import com.omprakash.onlineshopping.network.model.ProductsRequest;
import com.omprakash.onlineshopping.network.model.WishListResponse;
import com.omprakash.onlineshopping.products.WishListRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ShoppingService {

    @GET("categories")
    Call<CategoryResponse> fetchCategories();

    @POST("view_all_products")
    Call<ProductApiResponse> fetchProducts(@Body ProductsRequest request);

    @POST("insert_wishlist")
    Call<WishListResponse> addToWishList(@Body WishListRequest wishListRequest);

    @POST("delete_wishlist")
    Call<WishListResponse> removeFromWishList(@Body WishListRequest wishListRequest);
}
