package com.example.islamyroute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.framentContinar ,new FragmentQuran()).commit();
        bottomNavigation = findViewById(R.id.buttomNavigathion);

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.quran) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framentContinar ,new FragmentQuran()).commit();
                }else if (item.getItemId() == R.id.ahadith) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framentContinar ,new FragmentAhadith()).commit();
                }else if (item.getItemId() == R.id.sebha) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framentContinar ,new FragmentSebha()).commit();
                }else if (item.getItemId() == R.id.radio) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framentContinar ,new FragmentRadio()).commit();
                }
                return true;
            }
        });
    }
}