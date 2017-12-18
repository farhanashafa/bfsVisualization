package com.exampsdsle.israt.project;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Intro extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFF93A3A"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        TextView tv1 = (TextView) findViewById(R.id.t1);
        TextView tv2 = (TextView)findViewById(R.id.t2);
        TextView tv3 = (TextView)findViewById(R.id.t3);
        TextView tv4 = (TextView)findViewById(R.id.t4);
        TextView tv5 = (TextView)findViewById(R.id.t5);
        ImageView iv = (ImageView)findViewById(R.id.iv);


        YoYo.with(Techniques.BounceIn)
                .duration(2000)
                .playOn(findViewById(R.id.t1));
        YoYo.with(Techniques.BounceIn)
                .duration(2000)
                .playOn(findViewById(R.id.t2));
        YoYo.with(Techniques.BounceIn)
                .duration(2000)
                .playOn(findViewById(R.id.t3));
        YoYo.with(Techniques.BounceIn)
                .duration(2000)
                .playOn(findViewById(R.id.t4));
        YoYo.with(Techniques.BounceIn)
                .duration(2000)
                .playOn(findViewById(R.id.t5));

        tv1.setText("BFS: \n");
        tv2.setText("Breadth-first-search is one of the simplest algorithms for searching a" +
                " graph and the archetype for many important graph algorithms."+"It starts at the tree " +
                "root and explores the neighbour nodes first, before moving to the next level neighbors."+"\n");
        tv3.setText("Overall Strategy of BFS Algorithm:\n");
        tv4.setText("Breadth-first search starts at a given vertex s,which is at level 0."+
                " In the first stage, we visit all the vertices that are at the distance of one edge away." +"When we visit there, " +
                "we paint as \"visited,\" the vertices adjacent to the start vertex s - these vertices are placed into level 1."+
        " In the second stage, we visit all the new vertices we can reach at the distance of two edges away from the source vertex s."+
        "These new vertices, which are adjacent to level 1 vertices and not previously assigned to a level, are placed into level 2, and so on."+
        "The BFS traversal terminates when every vertex has been visited."+"\n");
        tv5.setText("Algorithm: Breadth-First Search Traversal:");
    }
}
