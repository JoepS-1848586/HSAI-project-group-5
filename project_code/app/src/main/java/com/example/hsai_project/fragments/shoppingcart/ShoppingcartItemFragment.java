package com.example.hsai_project.fragments.shoppingcart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hsai_project.R;


public class ShoppingcartItemFragment extends Fragment {

    public ShoppingcartItemFragment() {
        // Required empty public constructor
    }

    private Integer amount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_shoppingcart_item, container, false);

        final EditText amounttext = root.findViewById(R.id.shoppingcart_item_amounttext);
        amounttext.setText(amount.toString());

        Button addbutton = root.findViewById(R.id.shoppingcart_item_addbutton);
        final Button removebutton = root.findViewById(R.id.shoppingcart_item_removebutton);
        removebutton.setVisibility(View.INVISIBLE);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++amount;
                amounttext.setText(amount.toString());
                if(amount > 1)
                    removebutton.setVisibility(View.VISIBLE);
            }
        });

        removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --amount;
                if(amount <= 1) {
                    amount = 1;
                    removebutton.setVisibility(View.INVISIBLE);
                }
                amounttext.setText(amount.toString());
            }
        });

        return root;
    }
}
