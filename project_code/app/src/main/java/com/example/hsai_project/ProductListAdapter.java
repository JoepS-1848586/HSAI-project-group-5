package com.example.hsai_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductHoler> {
    private List<ProductEntity>products = new ArrayList<>();
    @NonNull
    @Override
    public ProductHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_view, parent, false);
        return new ProductHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHoler holder, int position) {
        ProductEntity currentProduct = products.get(position);
        holder.textViewName.setText(currentProduct.getProductName());
        holder.textViewPrice.setText(String.valueOf(currentProduct.getPrice()));
        Glide.with(holder.ViewImage.getContext()).load(currentProduct.getImage()).into(holder.ViewImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<ProductEntity>products){
        this.products = products;
        notifyDataSetChanged();
    }

    class ProductHoler extends RecyclerView.ViewHolder{
        private TextView textViewName;
        private TextView textViewPrice;
        private ImageView ViewImage;

        public ProductHoler(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.product_text);
            textViewPrice = itemView.findViewById(R.id.product_price);
            ViewImage = itemView.findViewById(R.id.product_image);
        }
    }
}
