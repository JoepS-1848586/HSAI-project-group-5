package com.example.hsai_project.fragments.shoppingcart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingcartFragment extends Fragment {

    private static int REQUEST_CODE_DELETE_ITEMS = 0;

    List<ShoppingcartItem> m_data;
    List<ShoppingcartItemFragment> m_frags = new ArrayList<ShoppingcartItemFragment>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_shoppingcart, container, false);

        Button deletebutton = root.findViewById(R.id.shoppingcart_deletebutton);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShoppingcartDelete.class);
                startActivityForResult(intent, REQUEST_CODE_DELETE_ITEMS);
            }
        });
        getEntries();

        return root;
    }

    public void getEntries(){
        ProductDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ProductDatabase.class, "shoppincart_table")
                .allowMainThreadQueries().build();

        //m_data = db.productDao().getAllShoppingcartProducts();

        m_data = new ArrayList<ShoppingcartItem>();
        m_data.add(new ShoppingcartItem(1,"testprod", 150, "testStore", 2));
        m_data.add(new ShoppingcartItem(2,"testprod2", 300, "testStore", 4));

        for(int i = 0; i < m_data.size();++i){
            addFragment(m_data.get(i));
        }
    }

    public void addFragment(ShoppingcartItem data){
        ShoppingcartItemFragment frag = new ShoppingcartItemFragment( data);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.shoppincart_fragmentcontainer, frag);
        transaction.commit();
        m_frags.add(frag);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_DELETE_ITEMS){
            if(resultCode == Activity.RESULT_OK){
                int[] d = data.getIntArrayExtra(ShoppingcartDelete.EXTRA_REMOVED_ITEM_IDS);
                deleteItems(d);
                Toast.makeText(getActivity(), "Items removed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteItems(int[] itemids){
        for(int i = 0; i < itemids.length;++i){
            int id = itemids[i];
            for(int j =0; j < m_data.size();++j){
                if(m_data.get(j).getId() == id){
                    removeItem(j);
                    break;
                }
            }
        }
    }

    private void removeItem(int index){
        // TODO remove item out of database
        m_data.remove(index);

        ShoppingcartItemFragment item = m_frags.remove(index);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.remove(item);
        transaction.commit();
    }


}