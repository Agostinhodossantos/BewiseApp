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
import com.app.bewise.model.Subject;
import com.app.bewise.ui.library.BookListActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder> {

    private Context mContext;
    private List<Subject> subjectList;

    public SubjectAdapter(Context mContext, List<Subject> subjectList) {
        this.mContext = mContext;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_menu_subject, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



    }


    @Override
    public int getItemCount() {
        return subjectList.size();
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
