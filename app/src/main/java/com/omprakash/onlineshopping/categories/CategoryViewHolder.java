package com.omprakash.onlineshopping.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.onlineshopping.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CategoryItemBinding binding;

    public CategoryViewHolder(CategoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
