package com.thmobile.cirestechnologiesproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thmobile.cirestechnologiesproject.R;
import com.thmobile.cirestechnologiesproject.utils.DataModel;

import java.util.ArrayList;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.RecyclerHolder> {

    private ArrayList<DataModel> dataModels = new ArrayList<>();

    static class RecyclerHolder extends RecyclerView.ViewHolder {

        //init Views of Lists
        ImageView imageViewItemList;
        TextView textViewItemList;
        TextView textViewDate;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItemList = itemView.findViewById(R.id.imageViewItemList);
            textViewItemList = itemView.findViewById(R.id.textViewItemList);
            textViewDate = itemView.findViewById(R.id.textViewItemListDate);
        }
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_list, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        //Put values to Views
        DataModel singleModel = dataModels.get(position);
        Picasso.get().load(singleModel.getImageUrl()).into(holder.imageViewItemList);
        holder.textViewItemList.setText(singleModel.getTitle());
        holder.textViewDate.setText(singleModel.getTime()+"--"+singleModel.getDate());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public void updateList(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
        notifyDataSetChanged();
    }
}