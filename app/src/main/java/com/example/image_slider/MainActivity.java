package com.example.image_slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //creating object of viewpager
    ViewPager viewPager;

    int[] images = {R.drawable.doramon,R.drawable.jerry,R.drawable.micky,R.drawable.tiger};

    //creating object of viewpagerAdapter
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the viewpager object
        viewPager = findViewById(R.id.viewpager);

        //initializing viewpagerAdapter
        viewPagerAdapter = new ViewPagerAdapter(this,images);

        //Adding the Adapter to the viewPager
        viewPager.setAdapter(viewPagerAdapter);
    }
}