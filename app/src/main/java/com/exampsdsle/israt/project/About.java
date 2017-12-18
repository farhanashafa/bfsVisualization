package com.exampsdsle.israt.project;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Israt on 5/7/2016.
 */
public class About extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#35aad9"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        TextView tv = (TextView) findViewById(R.id.t1);
        TextView tv1 =(TextView) findViewById(R.id.t2);
        TextView tv2 =(TextView) findViewById(R.id.t3);
        TextView tv3 =(TextView) findViewById(R.id.t4);


        YoYo.with(Techniques.FlipInX)
        .duration(3000)
        .playOn(findViewById(R.id.t1));

        YoYo.with(Techniques.FlipInX)
                .duration(3000)
                .playOn(findViewById(R.id.t2));

        YoYo.with(Techniques.FlipInX)
                .duration(3000)
                .playOn(findViewById(R.id.t3));

        YoYo.with(Techniques.FlipInX)
                .duration(3000)
                .playOn(findViewById(R.id.t4));
    }
}
