package com.omprakash.onlineshopping.products;

import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.onlineshopping.databinding.CategoryItemBinding;
import com.omprakash.onlineshopping.databinding.ProductItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ProductItemBinding binding;

    public ProductViewHolder(ProductItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
