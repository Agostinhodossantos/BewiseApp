package com.app.bewise.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        initUI();
        initRanking();

        toolbar.setTitle("sweetheart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void initRanking() {

        List<Ranking> rankingList = new ArrayList<>();
        rankingList.add(new Ranking(10, 3, "Agostinho Dos Santos"));
        rankingList.add(new Ranking(45, 3, "Ana Maria"));
        rankingList.add(new Ranking(53, 3, "Helton Junior"));
        rankingList.add(new Ranking(54, 3, "Jessica Ramires"));
        rankingList.add(new Ranking(24, 3, "Jorge Dos Santos"));
        rankingList.add(new Ranking(59, 3, "Katia Marcos"));

        RankingAdapter adapter = new RankingAdapter(this, rankingList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rv_ranking.setLayoutManager(layoutManager);
        rv_ranking.setAdapter(adapter);
    }

    private void initUI() {
        toolbar = findViewById(R.id.toolbar);
        rv_ranking = findViewById(R.id.rv_ranking);
    }
}