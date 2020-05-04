package com.example.hsai_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsai_project.R;


public class ProductViewFragment extends Fragment {

    private boolean m_fav = false;
    private TextView m_name;
    private TextView m_price;

    public ProductViewFragment() {
        // Required empty public constructor
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

        m_name = (TextView) root.findViewById(R.id.product_text);
        // TODO set name
        m_price = (TextView) root.findViewById(R.id.product_price);
        // TODO set price


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
        if(m_fav)
            view.setImageResource(R.drawable.ic_favorite_black_24dp);
        else
            view.setImageResource(R.drawable.ic_favorite_border_black_24dp);
    }

    private void onClick(){

    }

}
