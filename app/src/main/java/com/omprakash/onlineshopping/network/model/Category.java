package com.omprakash.onlineshopping.network.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("category_name")
    private String categoryName;

    private String image;

    @SerializedName("created_on")
    private String createdOn;

    @SerializedName("modified_on")
    private String modifiedOn;

    @SerializedName("delete_status")
    private String deleteStatus;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
