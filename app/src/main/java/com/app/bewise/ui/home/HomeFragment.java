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
import com.app.bewise.ui.study.StudyActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView card_jobs, card_study, card_publication, card_more;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initUI(root);

        card_jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StudyActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    private void initUI(View root) {
        card_jobs = root.findViewById(R.id.card_jobs);
        card_more = root.findViewById(R.id.card_more);
        card_publication = root.findViewById(R.id.card_publication);
        card_study = root.findViewById(R.id.card_study);
    }
}