package com.app.bewise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.Book;
import com.app.bewise.model.Job;
import com.app.bewise.ui.jobs.JobOverViewActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class JobsListAdapter extends RecyclerView.Adapter<JobsListAdapter.MyViewHolder> {

    private Context mContext;
    private List<Job> jobList;

    public JobsListAdapter(Context mContext, List<Job> jobList) {
        this.mContext = mContext;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_job_horizontal, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, JobOverViewActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.ll_card_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.img_cover.callOnClick();
            }
        });
    }


    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll_card_job;
        private RoundedImageView img_cover;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ll_card_job = itemView.findViewById(R.id.ll_job_card);
            img_cover = itemView.findViewById(R.id.img_job_cover);

        }
    }
}
