package com.app.bewise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.Book;
import com.app.bewise.model.BookCategory;
import com.app.bewise.ui.library.BookListActivity;

import java.util.List;

public class BooksCategoryAdapter extends RecyclerView.Adapter<BooksCategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<BookCategory> bookList;

    public BooksCategoryAdapter(Context mContext, List<BookCategory> bookList) {
        this.mContext = mContext;
        this.bookList = bookList;
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
        holder.card_category.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, BookListActivity.class);
            mContext.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView card_category;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_category = itemView.findViewById(R.id.card_category);
        }
    }
}
