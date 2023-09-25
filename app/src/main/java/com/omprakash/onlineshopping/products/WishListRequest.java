package com.omprakash.onlineshopping.products;

import com.google.gson.annotations.SerializedName;

public class WishListRequest {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("product_id")
    private String productId;

    public WishListRequest() {
    }

    public WishListRequest(String userId, String categoryId, String productId) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}