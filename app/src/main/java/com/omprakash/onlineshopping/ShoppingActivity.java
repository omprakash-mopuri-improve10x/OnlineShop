package com.omprakash.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.omprakash.onlineshopping.categories.CategoriesAdapter;
import com.omprakash.onlineshopping.databinding.ActivityShoppingBinding;
import com.omprakash.onlineshopping.network.model.Category;
import com.omprakash.onlineshopping.network.model.CategoryResponse;
import com.omprakash.onlineshopping.network.model.Product;
import com.omprakash.onlineshopping.products.OnProductActionListener;
import com.omprakash.onlineshopping.products.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity implements ShoppingContract.View {

    private ActivityShoppingBinding binding;
    private CategoriesAdapter categoriesAdapter;
    private ShoppingPresenter presenter;
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ShoppingPresenter(this);
        setupCategoriesAdapter();
        setupCategoriesRv();
        presenter.fetchCategories();
        setupProductsAdapter();
        setupProductsRv();
    }

    private void setupCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setOnCategoryActionListener(category -> {
            presenter.fetchProducts(category);
        });
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }

    @Override
    public void showCategories(List<Category> categories) {
        categoriesAdapter.setCategories(categories);
    }

    @Override
    public void showProducts(int productsCount, List<Product> products) {
        binding.productsCountTxt.setText(productsCount + " Items");
        productsAdapter.setProducts(products);
    }

    private void setupProductsAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setOnProductActionListener(new OnProductActionListener() {
            @Override
            public void onAddToWishList(Product product) {
                presenter.addToWishList(product);
            }

            @Override
            public void removeFromWishList(Product product) {
                presenter.removeFromWishList(product);
            }
        });
    }

    private void setupProductsRv() {
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productsRv.setAdapter(productsAdapter);
    }
}