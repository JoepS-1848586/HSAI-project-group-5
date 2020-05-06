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

import com.example.hsai_project.R;

import java.util.ArrayList;
import java.util.List;

public class ReservationsFragment extends Fragment {

    List<ReservationsItemFragment> m_frags = new ArrayList<ReservationsItemFragment>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_reservations, container, false);

        addFragment(new ReservationItem(0,"productnametes", 300, "storenametest", 5));

        return root;
    }

    private void addFragment(ReservationItem data){
        ReservationsItemFragment frag = new ReservationsItemFragment( data, this);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.reservations_fragmentcontrainer, frag);
        transaction.commit();
        m_frags.add(frag);
    }

    public void cancelReservation(ReservationsItemFragment frag){
        // TODO: remove item out of database
        ReservationItem item = frag.getItem();

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.remove(frag);
        transaction.commit();

        m_frags.remove(frag);
    }
}