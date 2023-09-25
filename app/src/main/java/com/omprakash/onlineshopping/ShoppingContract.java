package com.omprakash.onlineshopping;

import com.omprakash.onlineshopping.network.model.Category;
import com.omprakash.onlineshopping.network.model.Product;

import java.util.List;

public interface ShoppingContract {

    interface View {
        void showCategories(List<Category> categories);
        void showProducts(int productsCount, List<Product> products);
    }

    interface Presenter {
        void fetchCategories();
        void fetchProducts(Category category);
        void addToWishList(Product product);
        void removeFromWishList(Product product);
    }
}
