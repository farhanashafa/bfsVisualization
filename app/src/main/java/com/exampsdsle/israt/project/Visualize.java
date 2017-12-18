package com.exampsdsle.israt.project;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class Visualize extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualize);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FDF9A2CD"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
    }



}
