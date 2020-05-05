package com.example.hsai_project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.hsai_project.R;

public class ProductsFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_products, container, false);

        String[] categories = {"Laptops & Computers", "Telefoons", "Huishouden", "Gaming & Entertainment"};
        ListView categorieView = (ListView)root.findViewById(R.id.productCategoriesList);

        ArrayAdapter<String>categoriesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, categories);
        categorieView.setAdapter(categoriesAdapter);

        categorieView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    ProductCategorieFragment chosenCategorie = new ProductCategorieFragment();
                    Navigation.findNavController(root).navigate(R.id.product_categorie_sub);

                    /*FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.product_categorie, chosenCategorie);
                    transaction.commit();*/
                }
            }
        });


        //final TextView textView = root.findViewById(R.id.text_products);
        //textView.setText("products");

        return root;
    }
}
