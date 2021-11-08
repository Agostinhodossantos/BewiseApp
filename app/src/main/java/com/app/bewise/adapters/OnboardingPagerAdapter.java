package com.app.bewise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.app.bewise.R;
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

        View view = LayoutInflater.from(context).inflate(R.layout.item_onboarding, null, false);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_description = view.findViewById(R.id.tv_description);
        ImageView img_onboarding = view.findViewById(R.id.img_onboarding);

        tv_description.setText(onboardingList.get(position).getDescription());
        tv_title.setText(onboardingList.get(position).getTitle());
        img_onboarding.setImageDrawable(onboardingList.get(position).getImg());

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
        //destroyItem(container, position, object);
    }
}
