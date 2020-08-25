package com.ahmedkgamil.zoomedimagesliderexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmedkgamil.zoomedimageslider.ZoomedImageSlider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> images = new ArrayList<>();
        images.add("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png");
        images.add("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg");
        images.add("https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697");

        ZoomedImageSlider zoomedImageSlider = findViewById(R.id.mainImageSlider);

        zoomedImageSlider.loadImages(images);
    }
}