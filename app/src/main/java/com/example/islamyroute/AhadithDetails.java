package com.example.islamyroute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AhadithDetails extends AppCompatActivity {

    TextView hadithDetailsTV ;
    TextView hadithNameTV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahadith_details);
        hadithDetailsTV = findViewById(R.id.hadithDetailsTV);
        hadithNameTV = findViewById(R.id.hadithNameTV);
        String hadithName = getIntent().getStringExtra("hadith_name");
        String fileName = getIntent().getStringExtra("file_name");
        readHadithFile(fileName);
        hadithNameTV.setText(hadithName);
    }

    private void readHadithFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                hadithDetailsTV.append(mLine);
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