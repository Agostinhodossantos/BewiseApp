package com.app.bewise.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.ui.library.adapter.VPadapter;
import com.app.bewise.ui.library.fragments.FirstFragment;
import com.app.bewise.ui.library.fragments.SecondFragment;
import com.app.bewise.ui.library.fragments.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initUI();
    }
    private void initUI() {

    }


}