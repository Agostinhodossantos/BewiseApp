package com.app.bewise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.app.bewise.model.Onboarding;

import java.util.List;

public class OnboardingPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Onboarding> onboardingList;


    public OnboardingPagerAdapter(Context context, List<Onboarding> onboardingList) {
        this.context = context;
        this.onboardingList = onboardingList;
    }


    @Override
    public int getCount() {
        return onboardingList.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.)

        return super.instantiateItem(container, position);
    }
}
