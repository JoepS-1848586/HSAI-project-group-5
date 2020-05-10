package com.example.hsai_project.fragments.reservations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.hsai_project.ProductDatabase;
import com.example.hsai_project.R;

import java.util.ArrayList;
import java.util.List;

public class ReservationsFragment extends Fragment {

    List<ReservationItem> m_items;
    List<ReservationsItemFragment> m_frags = new ArrayList<ReservationsItemFragment>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_reservations, container, false);

        ProductDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ProductDatabase.class, "reservation_table")
                .allowMainThreadQueries().build();

        m_items = db.productDao().getAllReservations().getValue();

        TextView emptytext = (TextView) root.findViewById(R.id.reservations_empty);
        if(m_items == null || m_items.size() <= 0) {
            emptytext.setVisibility(View.VISIBLE);
            return root;
        }

        emptytext.setVisibility(View.INVISIBLE);

        for(int i = 0; i < m_items.size(); ++i) {
            addFragment(m_items.get(i));
        }

        return root;
    }

    public void addFragment(ReservationItem data){
        ReservationsItemFragment frag = new ReservationsItemFragment( data, this);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.reservations_fragmentcontrainer, frag);
        transaction.commit();
        m_frags.add(frag);
    }

    public void cancelReservation(ReservationsItemFragment frag){
        ReservationItem item = frag.getItem();
        ProductDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ProductDatabase.class, "reservation_table")
                .allowMainThreadQueries().build();
        db.productDao().deleteFromReservations(item.getId());


        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.remove(frag);
        transaction.commit();

        m_frags.remove(frag);
    }
}