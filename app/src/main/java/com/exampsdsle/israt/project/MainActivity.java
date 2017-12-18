package com.exampsdsle.israt.project;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;



import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView b1 = (CardView) findViewById(R.id.b1);
        CardView b4 = (CardView) findViewById(R.id.b4);
        CardView b3 = (CardView) findViewById(R.id.b3);
        CardView b2 = (CardView) findViewById(R.id.b2);


        DisplayMetrics dis = getApplicationContext().getResources().getDisplayMetrics();
        int width = dis.widthPixels;
        int hight = dis.heightPixels;

        int x = width / 2;
        b1.setMinimumHeight(hight / 2);
        b3.setMinimumWidth(width / 2);
        b2.setMinimumWidth(width / 2);
        b4.setMinimumHeight(hight / 2);

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(findViewById(R.id.b2));
        YoYo.with(Techniques.BounceInLeft)
                .duration(1000)
                .playOn(findViewById(R.id.b3));
        YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .playOn(findViewById(R.id.b1));
        YoYo.with(Techniques.BounceInUp)
                .duration(2000)
                .playOn(findViewById(R.id.b4));



       b1.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {


               startActivity(new Intent(getApplicationContext(), Intro.class));
           }

       });


        //Button button2=(Button)findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),User_input.class));
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Auto_input.class));
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),About.class));
            }

        });

    }


}
