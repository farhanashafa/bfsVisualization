package com.exampsdsle.israt.project;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Israt on 4/27/2016.
 */
public class User_input extends AppCompatActivity {

    int [][]array = new int[10][10];
    int node, edge;
    int count=0;
    EditText e1,e2,e3,e4,bar,src;
    int valueX[],valueY[];
    TextView txt;
    String str="";
    LinearLayout lay1,lay2;
    Button add,save,ok;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_input);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FDF9A2CD"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        getSupportActionBar().setBackgroundDrawable(colorDrawable);
       //

        DisplayMetrics dis = getApplicationContext().getResources().getDisplayMetrics();
        int width = dis.widthPixels;

        lay1 = (LinearLayout) findViewById(R.id.lay1);
        lay2 = (LinearLayout) findViewById(R.id.lay2);

        lay2.setVisibility(View.GONE);



        e1 = (EditText) findViewById(R.id.et1);
       // int a= Integer.parseInt(e1.getText().toString());
        e2 = (EditText) findViewById(R.id.et2);
        //int b= Integer.parseInt(e2.getText().toString());
        for( int i = 0; i < 10; i++){
            for( int j = 0; j < 10 ; j++){
                array[i][j] = 0;
            }
        }

            e3 = (EditText) findViewById(R.id.et3);
            e4 = (EditText) findViewById(R.id.et4);
            e3.setWidth(width/3);
            e4.setWidth(width /3);
            src =(EditText) findViewById(R.id.src);


        txt = (TextView)findViewById(R.id.res);
        bar = (EditText) findViewById(R.id.et3);
        add = (Button) findViewById(R.id.add);
        save = (Button) findViewById(R.id.save);
        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),Integer.parseInt((src.getText().toString())) , Toast.LENGTH_LONG).show();
                String ff = src.getText().toString();

                Log.d("give valid input",ff);
                 int  c=0,f=0;

                try {
                    f = Integer.parseInt(ff);
                }
                catch (Exception e)
                {
                    Log.d("give valid input", e.toString());
                }

                if (f<9 && f>0)
                {
                    lay2.setVisibility(View.GONE);
                    setContentView(new drawNodeEdge(getApplicationContext(),valueX,valueY,f,edge));
                    /////////////////////
                }
               /* else {


                    if (f < 1 || c < 1) {
                        YoYo.with(Techniques.Wave)
                                .duration(500)
                                .playOn(findViewById(R.id.et3));
                        YoYo.with(Techniques.Wobble)
                                .duration(500)
                                .playOn(findViewById(R.id.et4));
                        YoYo.with(Techniques.RubberBand)
                                .duration(500)
                                .playOn(findViewById(R.id.src));
                        Toast.makeText(getApplicationContext(), "Fill all the requirements", Toast.LENGTH_LONG).show();
                        //lay2.setVisibility(View.VISIBLE);
                    }*/

                    else
                    {
                        YoYo.with(Techniques.Tada)
                                .duration(500)
                                .playOn(findViewById(R.id.src));
                        Toast.makeText(getApplicationContext(), "Give valid source", Toast.LENGTH_LONG).show();
                    }

            }

        });

        add.setOnClickListener(new View.OnClickListener() {
           // String str = "";
            public void onClick(View v)
            {
                checkInputNodes();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aa = e1.getText().toString();
                Log.d("give valid input",aa);
                String bb = e2.getText().toString();

                int  a=0,b=0;

                try {
                    a = Integer.parseInt(aa);
                    b = Integer.parseInt(bb);
                }
                catch (Exception e)
                {
                    Log.d("give valid input", e.toString());
                }

                if (a<9 && a>0)
                {
                    node = a;
                    edge = b;
                    valueX = new int[edge];
                    valueY = new int [edge];

                    lay1.setVisibility(View.GONE);
                    lay2.setVisibility(View.VISIBLE);
                }
                else
                {
                    if(a<1||b<1)
                    {
                        YoYo.with(Techniques.RubberBand)
                                .duration(500)
                                .playOn(findViewById(R.id.et1));
                        YoYo.with(Techniques.RubberBand)
                                .duration(500)
                                .playOn(findViewById(R.id.et2));
                        Toast.makeText(getApplicationContext(), "Enter something in both field", Toast.LENGTH_LONG).show();
                        lay1.setVisibility(View.VISIBLE);

                    }

                    else {
                        YoYo.with(Techniques.Tada)
                                .duration(500)
                                .playOn(findViewById(R.id.et1));
                        Toast.makeText(getApplicationContext(), "Enter node less than 9", Toast.LENGTH_LONG).show();
                        //YoYo.with(Techniques.Tada)
                        // .duration(1000)
                        // .playOn(findViewById(R.id.et2));
                        //Toast.makeText(getApplicationContext(), "Limit edge no", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
    }

    public void checkInputNodes()
    {
        int x,y;
        String et1 = e3.getText().toString();
        String et2 = e4.getText().toString();
        try {
            x = Integer.parseInt(et1);
            y = Integer.parseInt(et2);
            array[x][y] = 1;

            if (x<node || y<node) {
                str = str + x + " -> " + y+"\n";
                txt.setText(str);
                valueX[count]=x;
                valueY[count]=y;
                count++;
                if (count==edge)
                {
                    LinearLayout mylinear = (LinearLayout) findViewById(R.id.mylinear);
                    mylinear.setVisibility(View.GONE);
                    add.setVisibility(View.GONE);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Please enter valid node",Toast.LENGTH_LONG).show();
            }
            e3.setText("");
            e4.setText("");
            e4.clearFocus();
        }
        catch (Exception e)
        {

            Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_LONG).show();
        }
    }
}
