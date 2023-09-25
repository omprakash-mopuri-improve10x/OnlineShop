package com.omprakash.onlineshopping.products;

import com.omprakash.onlineshopping.network.model.Product;

public interface OnProductActionListener {
    void onAddToWishList(Product product);
    void removeFromWishList(Product product);
}
