package com.app.bewise.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.adapters.OnboardingPagerAdapter;
import com.app.bewise.model.Onboarding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class OnboardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

         initUI();
         initAds();


    }

    private void initUI() {
        viewPager = findViewById(R.id.vp_onboarding);
        circleIndicator = findViewById(R.id.indicator);
    }

    private void initAds() {
        OnboardingPagerAdapter pagerAdapter = new OnboardingPagerAdapter(getApplicationContext() , getOnboarding());
        viewPager.setAdapter(pagerAdapter);
        circleIndicator.setViewPager(viewPager);
    }

    private List<Onboarding> getOnboarding() {
        List<Onboarding> onboardings = new ArrayList<>();
        onboardings.add(new Onboarding("", "", 1));
        onboardings.add(new Onboarding("", "", 1));
        onboardings.add(new Onboarding("", "", 1));
        onboardings.add(new Onboarding("", "", 1));
        return onboardings;
    }
}