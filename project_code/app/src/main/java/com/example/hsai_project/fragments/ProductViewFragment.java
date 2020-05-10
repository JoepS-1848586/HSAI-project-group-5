package com.example.hsai_project.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsai_project.ProductDao;
import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.ProductEntity;
import com.example.hsai_project.R;
import com.example.hsai_project.WishlistEntity;

import com.bumptech.glide.Glide;

public class ProductViewFragment extends Fragment {

    private boolean m_fav = false;
    private ProductEntity m_product;


    public ProductViewFragment(ProductEntity product){
        m_product = product;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_product_view, container, false);
        // favorite button
        ImageView fav = (ImageView) root.findViewById(R.id.product_fav_button);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFavorite(v);
            }
        });

        TextView name = (TextView) root.findViewById(R.id.product_text);
        name.setText(m_product.getProductName());
        TextView price = (TextView) root.findViewById(R.id.product_price);
        price.setText(String.valueOf(m_product.getPrice()));

        ImageView image = (ImageView) root.findViewById(R.id.product_image);
        Glide.with(image.getContext()).load(m_product.getImage()).into(image);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // check update name and price from database
    }

    private void toggleFavorite(View v){
        ImageView view = ((ImageView)v);
        m_fav = !m_fav;
        if(m_fav) {
            view.setImageResource(R.drawable.ic_favorite_black_24dp);
            removeFromWishlist();
        }
        else {
            addToWishlist();
            view.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
    }


    private void addToWishlist(){
        new UpdateWishlistAsyncTask(ProductDatabase.getInstance(getContext()).productDao()).execute(new WishlistEntity(m_product.getId()));
    }

    private void removeFromWishlist(){
       new DeleteWishlistAsyncTask(ProductDatabase.getInstance(getContext()).productDao()).execute(m_product.getId());
    }

    private static class UpdateWishlistAsyncTask extends AsyncTask<WishlistEntity, Void, Void>{
        private ProductDao productDao;
        private UpdateWishlistAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }
        @Override
        protected Void doInBackground(WishlistEntity... entities) {
            for(int i = 0; i < entities.length;++i) {
                productDao.insertWishlist(entities[i]);
            }
            return null;
        }
    }

    private static class DeleteWishlistAsyncTask extends AsyncTask<Integer, Void, Void>{
        private ProductDao productDao;
        private DeleteWishlistAsyncTask(ProductDao productDao){
            this.productDao = productDao;
        }
        @Override
        protected Void doInBackground(Integer... ids) {
            for(int i = 0; i < ids.length;++i) {
                productDao.deleteWishlist(ids[i]);
            }
            return null;
        }
    }


}
