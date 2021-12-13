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
import com.app.bewise.interfaces.FilterInterface;
import com.app.bewise.model.BookCategory;
import com.app.bewise.model.ChipFilterModel;
import com.app.bewise.ui.library.BookListActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

import java.util.List;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.MyViewHolder> {

    private Context mContext;
    private List<ChipFilterModel> filterModelList;
    private FilterInterface.FilterListener filterLister;

    public ChipAdapter(Context mContext, List<ChipFilterModel> filterModelList, FilterInterface.FilterListener listener) {
        this.mContext = mContext;
        this.filterModelList = filterModelList;
        this.filterLister = filterLister;
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
        holder.option.setText(filterModelList.get(position).getTitle());
        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterLister.onFilter(filterModelList.get(position).getFilterValue());
                updateFilter();
            }
        });
    }

    private void updateFilter() {
    }


    @Override
    public int getItemCount() {
        return filterModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        
        private Chip option;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            
            option = itemView.findViewById(R.id.option);

        }
    }
}
