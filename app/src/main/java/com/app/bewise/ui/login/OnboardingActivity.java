package com.app.bewise.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.bewise.R;
import com.app.bewise.adapters.OnboardingPagerAdapter;
import com.app.bewise.model.Onboarding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class OnboardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    CircleIndicator circleIndicator;
    TextView tv_login, tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

         initUI();
         initAds();

         tv_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                 startActivity(intent);
             }
         });

         tv_register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                 startActivity(intent);
             }
         });


    }

    private void initUI() {
        viewPager = findViewById(R.id.vp_onboarding);
        circleIndicator = findViewById(R.id.indicator);
        tv_login = findViewById(R.id.tv_login);
        tv_register = findViewById(R.id.tv_register);
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
        return onboardings;
    }
}