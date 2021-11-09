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
import com.app.bewise.model.Ranking;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Ranking> rankingList;

    public RankingAdapter(Context mContext, List<Ranking> rankingList) {
        this.mContext = mContext;
        this.rankingList = rankingList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_ranking, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(rankingList.get(position).getName());
        holder.tv_score.setText(String.valueOf(rankingList.get(position).getScore()));
    }


    @Override
    public int getItemCount() {
        return rankingList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name, tv_score;
        private RoundedImageView img_profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_score = itemView.findViewById(R.id.tv_score);
            tv_name = itemView.findViewById(R.id.tv_name);
            img_profile = itemView.findViewById(R.id.img_profile);
        }
    }
}
