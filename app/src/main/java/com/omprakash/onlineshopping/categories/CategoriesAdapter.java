package com.omprakash.onlineshopping.categories;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.onlineshopping.databinding.CategoryItemBinding;
import com.omprakash.onlineshopping.network.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<Category> categories = new ArrayList<>();

    public void setOnCategoryActionListener(OnCategoryActionListener onCategoryActionListener) {
        this.onCategoryActionListener = onCategoryActionListener;
    }

    private OnCategoryActionListener onCategoryActionListener;



    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(binding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.binding.setCategory(category);
        holder.binding.getRoot().setOnClickListener(v -> {
            onCategoryActionListener.onCategoryClicked(category);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
