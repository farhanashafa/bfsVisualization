package com.exampsdsle.israt.project;

import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by Israt on 5/21/2016.
 */
public class drawNodeEdge extends View {
    int viewWidth, viewHeight, start, node1, node2;
    int graph[][];
    int edges, radius, source, controlFlag;
    int flag[], x1[], y1[], red[], next[];
    int visited[];
    Queue<Integer> temp, bfsQueue;
    boolean srcFlag;
    int point_x1, point_y1, point_x2, point_y2;
    float len, m1, m2, newx, newy;
    //int inc_x, inc_y;

    Paint paint;
    drawNodeEdge(Context context,int[]x,int[]y,int source,int edges){
        super(context);
        radius = 50;
        paint = new Paint();
        graph = new int[100][100];
        visited = new int[100];
        flag = new int[20];
        red = new int[20];
        next = new int[20];
        this.edges = edges;
        temp = new LinkedList<Integer>();
        bfsQueue = new LinkedList<Integer>();
        this.source = 1;     start = 0;
        srcFlag = false;
        controlFlag = 0;

        x1 = x;     y1 = y;
        for(int i = 0; i < edges; i++) {
            graph[x[i]][y[i]] = 1;
            graph[y[i]][x[i]] = 1;
        }
        for (int i = 0; i < 10; i++) {
            flag[i] = -1;
            visited[i] = 0;
            red[i] = 0;
            next[i] = 0;
        }
        for (int i = 0; i < edges; i++) {
            flag[x[i]] = 1;
            flag[y[i]] = 1;
        }
        for (int i = 0; i < 8; i++) {
            if (flag[i] == 1)
                node1++;
        }
        BFS(source);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        viewWidth = getWidth();
        viewHeight = getHeight();
        int w[] = { 3*viewWidth/4, viewWidth/4,  3*viewWidth/4, viewWidth/4, 5*viewWidth/6,
                viewWidth/6, viewWidth/2, viewWidth/2 };
        int h[] = { viewHeight/4, 3*viewHeight/4, 3*viewHeight/4, viewHeight/4, viewHeight/2,  viewHeight/2,
                viewHeight/8, 7*viewHeight/8};

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#fffbdb"));
        canvas.drawPaint(paint);
        /*for (int i = 0; i < edges; i++) {
            //if()
            drawLine(x1,y1,i,w,h,paint,canvas,Color.BLACK);
        }*/
        for( int i = 0; i < 8; i++){
            for( int j = 0; j < 8; j++){
                if( graph[i][j] == 1 ){
                    drawLine( i, j, w, h, paint, canvas, Color.parseColor("#FF64C6F1"));
                }
                if( graph[i][j] == 2 ){
                    drawLine( i, j, w, h, paint, canvas, Color.parseColor("#FFFFB862"));
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if (flag[i] != -1) {
                //if( red[i] == 1 && next[i] == 1 ){
                if( red[i] == 1 ){
                    drawCircle(i,w,h,paint,canvas,Color.parseColor("#FFFFB862"));
                }
                else{
                    drawCircle(i,w,h,paint,canvas,Color.parseColor("#FF64C6F1"));
                }
            }
        }
        if( srcFlag ){
            //temp.add(source);
            drawCircle(source, w, h, paint, canvas, Color.parseColor("#FFFFB862"));
            red[source] = 1;        //next[source] = 1;
            controlFlag = 1;
            srcFlag = false;
        }
        start++;
        if( start == 15 ){
            srcFlag = true;}
        if( controlFlag == 1 && red[source] == 1){
            node1 = bfsQueue.remove();
            node2 = bfsQueue.remove();
            point_x1 = w[node1];    point_y1 = h[node1];
            point_x2 = w[node2];    point_y2 = h[node2];
            len = (float) Math.sqrt((point_x1-point_x2)*(point_x1-point_x2) + (point_y1-point_y2)*(point_y1-point_y2));
            controlFlag = 2;
            m1 = (float) 0;
        }
        if( controlFlag == 2 ){
            m2 = len - m1;
            newx = (m1*point_x2 + m2*point_x1)/(m1+m2);
            newy = (m1*point_y2 + m2*point_y1)/(m1+m2);
            bfsDrawLine(point_x1, point_y1, newx, newy ,paint,canvas,Color.parseColor("#FFFFB862"));
            m1 += 3;
        }
        //if( newx >= point_x2 && newy >= point_y2 ){
        if( m1 > len ){
            drawCircle(node2 , w, h, paint, canvas, Color.parseColor("#FFFFB862"));
            red[node2] = 1;
            //next[node2] = 1;
            graph[node1][node2] = 2;
            graph[node2][node1] = 2;
            if( bfsQueue.isEmpty() ){
                controlFlag = 4;
            }
            else {
                controlFlag = 1;
            }
        }
        invalidate();
    }
    void drawCircle(int n, int w[], int h[],Paint paint,Canvas canvas,int color)
    {
        paint.setColor(color);
        canvas.drawCircle(w[n], h[n], radius, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(48f);
        canvas.drawText(String.valueOf(n), w[n] - 15, h[n] + 15, paint);
    }
    /*void drawLine(int x[], int y[],int n, int w[], int h[],Paint paint,Canvas canvas,int color)
    {
        paint.setStrokeWidth(8);
        paint.setColor(color);
        canvas.drawLine(w[x[n]], h[x[n]], w[y[n]], h[y[n]], paint);
    }*/
    void drawLine(int n1, int n2, int w[], int h[],Paint paint,Canvas canvas,int color)
    {
        paint.setStrokeWidth(8);
        paint.setColor(color);
        canvas.drawLine(w[n1], h[n1], w[n2], h[n2], paint);
    }
    void bfsDrawLine(float x1, float y1, float x2, float y2,Paint paint,Canvas canvas,int color)
    {
        paint.setStrokeWidth(8);
        paint.setColor(color);
        canvas.drawLine(x1,y1,x2,y2, paint);
    }
    void BFS( int src ){
        temp.add(src);
        visited[source] = 1;
        while(!temp.isEmpty()){
            int cur=temp.remove();
            for(int i=0; i<100; i++){
                if(graph[cur][i]==1 && visited[i]!=1){
                    bfsQueue.add(cur);
                    bfsQueue.add(i);
                    visited[i]=1;
                    temp.add(i);
                }
            }
        }
    }
}

