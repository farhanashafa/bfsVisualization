package com.exampsdsle.israt.project;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Auto_input extends AppCompatActivity{


    int source =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_input);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF8B84DE"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        int source =1;
        int x[] = {1, 1, 2, 4, 5, 1};
        int y[] = {2, 3, 4, 1, 3, 6};
        setContentView(new drawNodeEdge(this,x,y,source,6));







    }

}
