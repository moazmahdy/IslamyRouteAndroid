package com.example.islamyroute;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AhadithAdapter extends RecyclerView.Adapter<AhadithAdapter.ViewHolder> {
    public AhadithAdapter(ArrayList<String> list) {
        this.list = list;
    }

    ArrayList<String> list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hadith_name , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ahadithTV.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView ahadithTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ahadithTV = itemView.findViewById(R.id.itemAhadithTV);
        }
    }
}
