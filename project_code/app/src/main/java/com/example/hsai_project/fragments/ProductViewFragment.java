package com.example.hsai_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hsai_project.R;


public class ProductViewFragment extends Fragment {

    private boolean m_fav = false;

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
        ImageView fav = (ImageView) root.findViewById(R.id.product_fav_button);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView view = ((ImageView)v);
                m_fav = !m_fav;
                if(m_fav)
                    view.setImageResource(R.drawable.ic_favorite_black_24dp);
                else
                    view.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            }
        });
        return root;
    }
}
