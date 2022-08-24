package com.example.islamyroute;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FragmentQuran extends Fragment {

    ArrayList<String> list ;
    RecyclerView suraNameRecyclerView ;
    SuraNameAdapter adapter;
    public FragmentQuran() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillArray();
        suraNameRecyclerView = view.findViewById(R.id.suraNameRecyclerView);
        adapter = new SuraNameAdapter(list);
        adapter.onItemClickListener = new SuraNameAdapter.OnItemClickListener() {
            @Override
            public void onClick(String suraName, int index) {
                startQuranScreen(suraName , index+1+".txt");
            }
        };
        suraNameRecyclerView.setAdapter(adapter);
    }

    private void startQuranScreen(String suraName , String fileName) {
        Intent intent = new Intent(getActivity() , SuraDetails.class);
        intent.putExtra("sura_name" , suraName);
        intent.putExtra("file_name" , fileName);
        startActivity(intent);
    }

    public void fillArray (){
        String[] array = {"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
                ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
                ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
                ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
                ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
                ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
                ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
                ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
                ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
                "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};
        list = new ArrayList<String>(Arrays.asList(array));
    }
}