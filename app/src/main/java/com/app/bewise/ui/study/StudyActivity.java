package com.app.bewise.ui.study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.bewise.R;
import com.app.bewise.ui.study.game.ChooseSubjectActivity;

public class StudyActivity extends AppCompatActivity {

    Toolbar toolbar;
    private CardView card_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        initUI();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        card_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudyActivity.this, ChooseSubjectActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initUI() {
        card_game = findViewById(R.id.card_game);
        toolbar = findViewById(R.id.toolbar);
    }
}