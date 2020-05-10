package com.example.hsai_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.ProductEntity;
import com.example.hsai_project.R;
import com.example.hsai_project.WishlistEntity;


public class ProductViewFragment extends Fragment {

    private boolean m_fav = false;
    private ProductEntity m_product;


    public ProductViewFragment() {
        m_product = new ProductEntity("empty product name", 0, "empty product storename", "empty cat");
    }

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
        ProductDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ProductDatabase.class, "shoppincart_table")
                .allowMainThreadQueries().build();

        db.productDao().insertWishlist(new WishlistEntity(m_product.getId()));
    }

    private void removeFromWishlist(){
        ProductDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ProductDatabase.class, "shoppincart_table")
                .allowMainThreadQueries().build();

        db.productDao().deleteWishlist(m_product.getId());
    }

}
