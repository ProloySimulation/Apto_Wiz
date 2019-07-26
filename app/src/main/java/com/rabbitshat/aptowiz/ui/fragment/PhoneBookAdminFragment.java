package com.rabbitshat.aptowiz.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rabbitshat.aptowiz.R;
import com.rabbitshat.aptowiz.model.PhoneBook;
import com.rabbitshat.aptowiz.ui.adapter.PhoneBookAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RHAndroidPC on 12/10/2016.
 */

public class PhoneBookAdminFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<PhoneBook> listAdmin = new ArrayList<PhoneBook>();
    private PhoneBookAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PhoneBookAdapter(listAdmin,getContext());
        apiRequest();

    }

    private void apiRequest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setName("Proloy");
        listAdmin.add(phoneBook);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_phone_book_admin, container, false);
        if (v != null) {

            recyclerView = (RecyclerView) v.findViewById(R.id.rv_phone_book_admin);
            recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);

        }
        return v;
    }
}
