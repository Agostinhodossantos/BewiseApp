package com.app.bewise.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.adapters.JobsListAdapter;
import com.app.bewise.adapters.RankingAdapter;
import com.app.bewise.model.Ranking;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    private RecyclerView rv_ranking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        initUI();
        initRanking();
    }

    private void initRanking() {

        List<Ranking> rankingList = new ArrayList<>();
        rankingList.add(new Ranking(1, 3, ""));
        rankingList.add(new Ranking(1, 3, ""));
        rankingList.add(new Ranking(1, 3, ""));
        rankingList.add(new Ranking(1, 3, ""));

        RankingAdapter adapter = new RankingAdapter(this, rankingList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rv_ranking.setLayoutManager(layoutManager);
        rv_ranking.setAdapter(adapter);
    }

    private void initUI() {
        rv_ranking = findViewById(R.id.rv_ranking);
    }
}