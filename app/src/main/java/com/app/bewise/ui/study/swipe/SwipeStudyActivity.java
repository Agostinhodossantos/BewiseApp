package com.app.bewise.ui.study.swipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.adapters.SwipeAdapter;
import com.app.bewise.model.SwipeItem;

import java.util.ArrayList;
import java.util.List;

public class SwipeStudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_study);


        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        List<SwipeItem> videoItems = new ArrayList<>();

        //initialized into it the how many video you have to display...
        SwipeItem item = new SwipeItem();

        for (int i = 0; i < 4; i++) {
            item.videoUrl = "https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4";
            item.videoTitle = "FaceBook";
            item.videoDesc = "Facebook is the biggest giants";

            videoItems.add(item);

            item.videoUrl = "https://www.rmp-streaming.com/media/big-buck-bunny-360p.mp4";
            item.videoTitle = "Google is the internet company";
            item.videoDesc = "Google have have product to get ";

            videoItems.add(item);
        }
        viewPager2.setAdapter(new SwipeAdapter(videoItems));





    }
}