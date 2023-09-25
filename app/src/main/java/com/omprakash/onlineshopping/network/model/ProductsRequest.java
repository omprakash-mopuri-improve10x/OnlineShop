package com.omprakash.onlineshopping.network.model;

import com.google.gson.annotations.SerializedName;

public class ProductsRequest {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("category_id")
    private String categoryId;

    public ProductsRequest(String userId, String categoryId) {
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public ProductsRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
