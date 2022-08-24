package com.example.islamyroute;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SuraNameAdapter extends RecyclerView.Adapter<SuraNameAdapter.ViewHolder> {

    ArrayList<String> list;

    public SuraNameAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sura_name , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.suraName.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(list.get(position) , position);
            }
        });
    }

    OnItemClickListener onItemClickListener ;
    interface OnItemClickListener {
        public void onClick (String suraName, int index);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView suraName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            suraName = itemView.findViewById(R.id.itemSuraNameTV);
        }
    }
}
