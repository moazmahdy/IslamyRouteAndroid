package com.example.islamyroute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraDetails extends AppCompatActivity {

    //ArrayList<String> suraLines = new ArrayList<String>();
    TextView suraDetailsTV ;
    TextView suraNameTV ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        suraDetailsTV = findViewById(R.id.suraDetailsTV);
        suraNameTV = findViewById(R.id.suraDetailsSuraNameTV);
        String suraName = getIntent().getStringExtra("sura_name");
        String fileName = getIntent().getStringExtra("file_name");
        readSuraFile(fileName);
        suraNameTV.setText(suraName);
    }
    public void readSuraFile (String fileName){
        BufferedReader reader = null;
        try {
            final InputStream file = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                //suraLines.add(line);
                suraDetailsTV.append(line);
                line = reader.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}