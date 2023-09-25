package com.omprakash.onlineshopping.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductApiResponse {
    private String status;
    private String message;
    private ProductResponse response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductResponse getResponse() {
        return response;
    }

    public void setResponse(ProductResponse response) {
        this.response = response;
    }
}

