package com.omprakash.onlineshopping.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryResponse {
    private Boolean status;
    private String message;
    @SerializedName("response")
    private ArrayList<Category> categories;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
