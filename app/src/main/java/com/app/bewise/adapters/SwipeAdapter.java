package com.app.bewise.adapters;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bewise.R;
import com.app.bewise.model.SwipeItem;

import java.util.List;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.VideoViewHolder> {

    private List<SwipeItem> mVideoItem;

    public SwipeAdapter(List<SwipeItem> mVideoItem) {
        this.mVideoItem = mVideoItem;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_swipe_container, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(mVideoItem.get(position));
    }

    @Override
    public int getItemCount() {
        return mVideoItem.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView mVideoView;
        TextView txtTitle, txtDesc;
        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoView = itemView.findViewById(R.id.videoview);
            txtDesc = itemView.findViewById(R.id.txtDescription);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
        void setVideoData(SwipeItem video) {
            txtTitle.setText(video.videoTitle);
            txtDesc.setText(video.videoDesc);
            mVideoView.setVideoPath(video.videoUrl);
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = mVideoView.getWidth() / (float) mVideoView.getHeight();
                    float scale = videoRatio / screenRatio;

                    if (scale >= 1f) {
                        mVideoView.setScaleX(scale);
                    } else {
                        mVideoView.setScaleY(1f / scale);
                    }
                }
            });

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
