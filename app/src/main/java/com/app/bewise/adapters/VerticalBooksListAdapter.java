package com.app.bewise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.Book;
import com.app.bewise.utils.Check;
import com.app.bewise.utils.StrFormat;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VerticalBooksListAdapter extends RecyclerView.Adapter<VerticalBooksListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> bookList;

    public VerticalBooksListAdapter(Context mContext, List<Book> bookList) {
        this.mContext = mContext;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_book_vertical, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(StrFormat.toUpperFirst(bookList.get(position).getTitle()));
        holder.tv_author.setText(StrFormat.toUpperFirst(bookList.get(position).getAuthor()));
        
        if (!Check.isEmpty(bookList.get(position).getImg())) {
            Picasso.get().load(bookList.get(position).getImg()).into(holder.img_cover);
        } else {
            // TODO: 12/1/21 show default thumbnail 
        }
    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView img_cover;
        private TextView tv_author, tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_cover = itemView.findViewById(R.id.img_cover);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
