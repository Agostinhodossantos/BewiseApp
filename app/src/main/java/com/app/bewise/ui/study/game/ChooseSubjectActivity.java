package com.app.bewise.ui.study.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.adapters.BooksCategoryAdapter;
import com.app.bewise.adapters.SubjectAdapter;
import com.app.bewise.model.Subject;
import com.app.bewise.ui.library.LibraryActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseSubjectActivity extends AppCompatActivity {

    private RecyclerView rv_subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_subject);

        initUI();
        initSubject();
    }

    private void initSubject() {

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject("1", "Quimica", 0));
        subjectList.add(new Subject("1", "Quimica", 0));
        subjectList.add(new Subject("1", "Quimica", 0));
        subjectList.add(new Subject("1", "Quimica", 0));

        SubjectAdapter adapter = new SubjectAdapter(this, subjectList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rv_subjects.setLayoutManager(layoutManager);
        rv_subjects.setAdapter(adapter);
    }

    private void initUI() {
        rv_subjects = findViewById(R.id.rv_subjects);
    }
}