package com.example.hsai_project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.ProductEntity;
import com.example.hsai_project.R;

import java.util.List;

public class ProductItemView extends Fragment {
    public static final String EXTRA_ID = "com.example.hsai_projects.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.example.hsai_projects.EXTRA_TITLE";
    public static final String EXTRA_PRICE = "com.example.hsai_projects.EXTRA_PRICE";

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View product = inflater.inflate(R.layout.fragment_product_item_view, container, false);
        ProductItemViewArgs args = ProductItemViewArgs.fromBundle(getArguments());
        final String productName= args.getProductName();
        int productPrice = args.getProductPrice();
        final String productImage = args.getProductImage();

        /*ImageView productImageView = product.findViewById(R.id.product_image_view);
        Glide.with(getContext()).load(productImage).into(productImageView);
        TextView productNameView = product.findViewById(R.id.product_name_view);
        productNameView.setText(productName);
        TextView productPriceView = product.findViewById(R.id.product_price_view);
        productPriceView.setText(String.valueOf(productPrice));*/
        final TextView productNameView = product.findViewById(R.id.product_name_view);

        ProductDatabase db = ProductDatabase.getInstance(getContext());
        final LiveData<List<ProductEntity>> m_data = db.productDao().getFullProduct(productPrice);


        m_data.observe(getViewLifecycleOwner(), new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> productEntities) {
                if (m_data.getValue() == null){

                }
                else {
                    productNameView.setText(m_data.getValue().get(0).getProductName());
                }
            }
        });



        return product;
    }
        ;
}
