package com.prajan.peertechz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.prajan.peertechz.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Typeface face;

        LinearLayout ll_image =(LinearLayout) findViewById(R.id.ll_logobg);


//        face = Typeface.createFromAsset(getAssets(), "fonts/AbrilFatface-Regular.otf.ttf");
        //  t = findViewById(R.id.tv_prof);
        //tv_prof.setTypeface(face);
        Animation animation= AnimationUtils.loadAnimation(SplashActivity.this, R.anim.animation);
        ll_image.startAnimation(animation);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };
        timer.start();
    }



}
