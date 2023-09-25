package com.omprakash.onlineshopping;

import android.util.Log;


import com.omprakash.onlineshopping.network.model.Category;
import com.omprakash.onlineshopping.network.model.CategoryResponse;
import com.omprakash.onlineshopping.network.ShoppingApi;
import com.omprakash.onlineshopping.network.ShoppingService;
import com.omprakash.onlineshopping.network.model.Product;
import com.omprakash.onlineshopping.network.model.ProductApiResponse;
import com.omprakash.onlineshopping.network.model.ProductsRequest;
import com.omprakash.onlineshopping.network.model.WishListResponse;
import com.omprakash.onlineshopping.products.WishListRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingPresenter implements ShoppingContract.Presenter {

    private ShoppingContract.View view;

    private ShoppingService shoppingService;

    public ShoppingPresenter(ShoppingContract.View view) {
        this.view = view;
        shoppingService = new ShoppingApi().createShoppingService();
    }

    @Override
    public void fetchCategories() {
        Call<CategoryResponse> call = shoppingService.fetchCategories();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                List<Category> categories = response.body().getCategories();
                view.showCategories(categories);
                if (categories != null && !categories.isEmpty()) {
                    fetchProducts(categories.get(0));
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.e("Presenter", t.getMessage(), t);
            }
        });
    }

    @Override
    public void fetchProducts(Category category) {
        Call<ProductApiResponse> call = shoppingService.fetchProducts(new ProductsRequest("1", category.getCategoryId()));
        call.enqueue(new Callback<ProductApiResponse>() {
            @Override
            public void onResponse(Call<ProductApiResponse> call, Response<ProductApiResponse> response) {
                view.showProducts(response.body().getResponse().getProductsCount(),
                        response.body().getResponse().getProducts());
            }

            @Override
            public void onFailure(Call<ProductApiResponse> call, Throwable t) {
                Log.e("Presenter", t.getMessage(), t);
            }
        });
    }

    @Override
    public void addToWishList(Product product) {
        Call<WishListResponse> call = shoppingService.addToWishList(
                new WishListRequest("1", product.getCategory_id(), product.getProduct_id()));
        call.enqueue(new Callback<WishListResponse>() {
            @Override
            public void onResponse(Call<WishListResponse> call, Response<WishListResponse> response) {

            }

            @Override
            public void onFailure(Call<WishListResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void removeFromWishList(Product product) {
        Call<WishListResponse> call = shoppingService.removeFromWishList(
                new WishListRequest("1", product.getCategory_id(), product.getProduct_id()));
        call.enqueue(new Callback<WishListResponse>() {
            @Override
            public void onResponse(Call<WishListResponse> call, Response<WishListResponse> response) {

            }

            @Override
            public void onFailure(Call<WishListResponse> call, Throwable t) {

            }
        });
    }
}
