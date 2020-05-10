package com.example.hsai_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistHolder> {
    private List<ProductEntity>wishlistproducts = new ArrayList<>();

    @NonNull
    @Override
    public WishlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View wishListView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_view, parent, false);
        return new WishlistHolder(wishListView);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistHolder holder, int position) {
        ProductEntity currentWishlistProduct = wishlistproducts.get(position);
        holder.wishlistProduct.setText(currentWishlistProduct.getProductName());
    }

    @Override
    public int getItemCount() {
        return wishlistproducts.size();
    }

    public void setWishlistproducts(List<ProductEntity> wishlistproducts){
        this.wishlistproducts = wishlistproducts;
        notifyDataSetChanged();
    }

    class WishlistHolder extends RecyclerView.ViewHolder{
        private TextView wishlistProduct;

        public WishlistHolder(@NonNull View itemView) {
            super(itemView);
            wishlistProduct = itemView.findViewById(R.id.product_text);
        }
    }



}

