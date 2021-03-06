package com.ahmedkgamil.zoomedimageslider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ZoomedImageSlider extends LinearLayout {

    public ZoomedImageSlider(@NonNull Context context) {
        super(context);
    }

    public ZoomedImageSlider(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomedImageSlider(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void downloadImages(List<String> images) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.zoomed_image_slider, this, true);
            ViewPager2 viewPager2 = findViewById(R.id.viewPagerImageSlider);

            List<SliderItem> sliderItems = new ArrayList<>();

            for (String image : images) {
                sliderItems.add(new SliderItem(image));
            }

            viewPager2.setAdapter(new SliderAdapter(getContext(), sliderItems));

            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setOffscreenPageLimit(3);
            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });
            viewPager2.setPageTransformer(compositePageTransformer);
        }
    }

    public void loadImages(List<Integer> images) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.zoomed_image_slider, this, true);
            ViewPager2 viewPager2 = findViewById(R.id.viewPagerImageSlider);

            List<SliderItem> sliderItems = new ArrayList<>();

            for (int image : images) {
                sliderItems.add(new SliderItem(image));
            }

            viewPager2.setAdapter(new SliderAdapter(getContext(), sliderItems));

            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setOffscreenPageLimit(3);
            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });
            viewPager2.setPageTransformer(compositePageTransformer);
        }
    }
}
