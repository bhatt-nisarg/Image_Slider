package com.example.image_slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //creating object of viewpager
    ViewPager viewPager;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000; //delay in milisecond before task is executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task execution
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


        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == images.length - 1){
                    currentPage=0;
                }
                viewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }

        },DELAY_MS,PERIOD_MS);


    }
}