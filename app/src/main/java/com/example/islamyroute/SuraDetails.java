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
import java.util.stream.Stream;

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
        Log.e("file name",fileName);
        suraNameTV.setText(suraName);
    }
    public void readSuraFile (String fileName){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                suraDetailsTV.append(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
    }
}