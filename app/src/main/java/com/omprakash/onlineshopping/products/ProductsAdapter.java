package com.omprakash.onlineshopping.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.onlineshopping.R;
import com.omprakash.onlineshopping.databinding.ProductItemBinding;
import com.omprakash.onlineshopping.network.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products = new ArrayList<>();

    public void setOnProductActionListener(OnProductActionListener onProductActionListener) {
        this.onProductActionListener = onProductActionListener;
    }

    private OnProductActionListener onProductActionListener;

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(binding);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        Picasso.get().load("https://kisanmart.co/kisanmart/" + product.getProduct_image()).into(holder.binding.productImage);
        holder.binding.setProduct(product);
        if (product.getWishlist_status().equals("1")) {
            holder.binding.heartImg.setImageResource(R.drawable.wishlist_star);
            holder.binding.heartImg.setOnClickListener(v -> {
                product.setWishlist_status("0");
                onProductActionListener.removeFromWishList(product);
                notifyDataSetChanged();
            });
        } else {
            holder.binding.heartImg.setImageResource(R.drawable.wishlist_unstar);
            holder.binding.heartImg.setOnClickListener(v -> {
                product.setWishlist_status("1");
                onProductActionListener.onAddToWishList(product);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}