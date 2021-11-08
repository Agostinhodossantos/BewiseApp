package com.app.bewise.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.bewise.R;

public class RankingActivity extends AppCompatActivity {
    private RecyclerView rv_ranking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        initUI();
    }

    private void initUI() {
        rv_ranking = findViewById(R.id.rv_ranking);
    }
}