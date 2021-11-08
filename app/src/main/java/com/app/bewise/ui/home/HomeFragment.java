package com.app.bewise.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.app.bewise.R;
import com.app.bewise.ui.jobs.JobsActivity;
import com.app.bewise.ui.main.RankingActivity;
import com.app.bewise.ui.study.StudyActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView card_jobs, card_study, card_publication, card_more;
    private FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initUI(root);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RankingActivity.class);
                startActivity(intent);
            }
        });

        card_jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), JobsActivity.class);
                startActivity(intent);
            }
        });

        card_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StudyActivity.class);
                startActivity(intent);
            }
        });
        
        card_publication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 11/2/2021 open publication view 
            }
        });
        
        card_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 11/2/2021 open drawer  
            }
        });
        return root;
    }

    private void initUI(View root) {
        floatingActionButton = root.findViewById(R.id.floatingActionButton);
        card_jobs = root.findViewById(R.id.card_jobs);
        card_more = root.findViewById(R.id.card_more);
        card_publication = root.findViewById(R.id.card_publication);
        card_study = root.findViewById(R.id.card_study);
    }
}