package com.app.bewise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.Book;
import com.app.bewise.model.BookCategory;
import com.app.bewise.ui.library.BookListActivity;
import com.google.android.material.card.MaterialCardView;


import java.util.List;

public class BooksCategoryAdapter extends RecyclerView.Adapter<BooksCategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<BookCategory> categoryList;

    public BooksCategoryAdapter(Context mContext, List<BookCategory> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_title_category.setText(categoryList.get(position).getTitle());
        holder.img_icon_category.setImageResource(categoryList.get(position).getImg());

        holder.material_card_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookListActivity.class);
                intent.putExtra("category", categoryList.get(position));
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private MaterialCardView material_card_category;
        private TextView tv_title_category;
        private ImageView img_icon_category;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            material_card_category = itemView.findViewById(R.id.material_card_category);
            tv_title_category = itemView.findViewById(R.id.tv_title_category);
            img_icon_category = itemView.findViewById(R.id.img_icon_category);
        }
    }
}
