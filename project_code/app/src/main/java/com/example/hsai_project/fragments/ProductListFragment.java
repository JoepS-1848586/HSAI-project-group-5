package com.example.hsai_project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hsai_project.ProductEntity;
import com.example.hsai_project.ProductListAdapter;
import com.example.hsai_project.ProductListViewModel;
import com.example.hsai_project.R;

import java.util.List;

public class ProductListFragment extends Fragment {
    private ProductListViewModel productListViewModel;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View product = inflater.inflate(R.layout.product_list, container, false);

        RecyclerView recyclerView = product.findViewById(R.id.recycler_view_products);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);

        final ProductListAdapter adapter = new ProductListAdapter();
        recyclerView.setAdapter(adapter);
        productListViewModel = ViewModelProviders.of(ProductListFragment.this).get(ProductListViewModel.class);



        productListViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> productEntities) {
                adapter.setProducts(productEntities);
            }
        });

        return product;
    }


        //final TextView textView = root.findViewById(R.id.text_products);
        //textView.setText("products");


}
