package com.example.islamyroute;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentSebha extends Fragment {

    Button numOfTasbeah;
    Button nameOfTasbeah;
    int counter = 1;
    int countOfTasbeh = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numOfTasbeah = view.findViewById(R.id.numOfTasbehButton);
        nameOfTasbeah = view.findViewById(R.id.nameOfTasbehButton);

        numOfTasbeah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter <= 33) {
                    numOfTasbeah.setText(counter + "");
                    counter++;
                    countOfTasbeh++;
                } else if (counter > 33) {
                    numOfTasbeah.setText("0");
                    counter = 0;
                    if (countOfTasbeh > 33 && countOfTasbeh <= 66) {
                        nameOfTasbeah.setText("الحمد لله");
                    } else if (countOfTasbeh <= 99) {
                        nameOfTasbeah.setText("الله أكبر");
                    } else {
                        nameOfTasbeah.setText("سبحان الله");
                        countOfTasbeh = 0;
                    }
                }
            }
        });
    }
}