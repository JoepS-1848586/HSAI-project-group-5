package com.example.hsai_project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.example.hsai_project.R;


public class ExploreScrollFragment extends Fragment {


    public ExploreScrollFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root =  inflater.inflate(R.layout.fragment_explore_scroll, container, false);
        final HorizontalScrollView hsv = root.findViewById(R.id.explore_scroll_view);
        ImageView right = root.findViewById(R.id.explore_scroll_right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hsv.smoothScrollBy(300,0);
            }
        });

        ImageView left = root.findViewById(R.id.explore_scroll_left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hsv.smoothScrollBy(-300,0);
            }
        });

        return root;
    }
}
