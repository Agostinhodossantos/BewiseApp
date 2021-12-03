package com.app.bewise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.BookCategory;
import com.app.bewise.model.ChipFilterModel;
import com.app.bewise.ui.library.BookListActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.MyViewHolder> {

    private Context mContext;
    private List<ChipFilterModel> filterModelList;

    public ChipAdapter(Context mContext, List<ChipFilterModel> filterModelList) {
        this.mContext = mContext;
        this.filterModelList = filterModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_chip, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return filterModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
