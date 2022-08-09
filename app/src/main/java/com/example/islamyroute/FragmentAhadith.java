package com.example.islamyroute;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentAhadith extends Fragment {


    RecyclerView ahadithRecyclerView ;
    public FragmentAhadith() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadith, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = fillArray();
        ahadithRecyclerView = view.findViewById(R.id.ahadithRecyclerView);
        AhadithAdapter adapter = new AhadithAdapter(list);
        ahadithRecyclerView.setAdapter(adapter);
    }

    private ArrayList<String> fillArray() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1 ;i <= 40 ;i++) {
            String s = "الحديث رقم " + i;
            list.add(s);
        }
        return list;
    }
}