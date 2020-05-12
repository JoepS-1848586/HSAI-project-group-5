package com.example.hsai_project.fragments;

import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.ProductEntity;
import com.example.hsai_project.ProductListViewModel;
import com.example.hsai_project.R;

import java.util.List;
import java.util.Vector;

public class CompareFragment extends Fragment {
    public ProductListFragment ProductCompare;
    private ProductListViewModel productListViewModel;
    Vector<ProductEntity>compareProducts = new Vector();
    /*public void fillVector(){
        for(int i = 0; i < ProductCompare.inCompareProducts.size(); i++){
            compareProducts.add(ProductCompare.inCompareProducts.get(i));
        }
    }*/
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_compare, container, false);
        final TextView compareProduct_1 = root.findViewById(R.id.compare_text_product_1);
        final TextView compareProduct_2 = root.findViewById(R.id.compare_text_product_2);
        final TextView product_1 = root.findViewById(R.id.compare_product_name_1);
        final TextView product_2 = root.findViewById(R.id.compare_product_name_2);
        ImageView product_image_1 = root.findViewById(R.id.compare_image_product_1);
        ImageView product_image_2 = root.findViewById(R.id.compare_image_product_2);

        compareProduct_1.setMovementMethod(new ScrollingMovementMethod());
        compareProduct_2.setMovementMethod(new ScrollingMovementMethod());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            compareProduct_1.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    compareProduct_2.scrollTo(scrollX, scrollY);
                }
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            compareProduct_2.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    compareProduct_1.scrollTo(scrollX, scrollY);
                }
            });
        }

        ProductDatabase db = ProductDatabase.getInstance(getContext());
        final LiveData<List<ProductEntity>>  m_data = db.productDao().getAllCompareProducts();

        if (m_data.getValue() == null){
            product_1.setText("No products selected");
            product_2.setText("No products selected");
        }

        m_data.observe(getViewLifecycleOwner(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> productEntities) {
                 product_1.setText(m_data.getValue().get(0).getProductName());
                 product_2.setText(m_data.getValue().get(1).getProductName());
            }
        });

        return root;
    }
}