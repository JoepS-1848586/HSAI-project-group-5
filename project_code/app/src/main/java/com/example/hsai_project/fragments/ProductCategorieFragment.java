package com.example.hsai_project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hsai_project.R;

public class ProductCategorieFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View categories = inflater.inflate(R.layout.fragment_product_subcategorie, container, false);


        return categories;
    }
}
