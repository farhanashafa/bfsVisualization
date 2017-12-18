package com.exampsdsle.israt.project;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.exampsdsle.israt.project.CanvasView;

/**
 * Created by Tiash on 5/6/2016.
 */
public class Graph
{
    CanvasView canvas;
    Graph(CanvasView canvas)
    {
        this.canvas = canvas;
    }

    public void DrawCircle(int x, int y, int rad, int color)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.addCircle(x,y,rad,Path.Direction.CCW);
        canvas.pathLists.add(canvas.historyPointer, path);
        canvas.paintLists.add(canvas.historyPointer, paint);
        canvas.historyPointer++;
        canvas.invalidate();
    }

    public void DrawLine(int x1,int y1,int x2, int y2,int color)
    {

        Paint mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(10);

        Path path = new Path();
        //path.addCircle(x,y,rad,Path.Direction.CCW);
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        //path.addArc();
        canvas.pathLists.add(canvas.historyPointer, path);
        canvas.paintLists.add(canvas.historyPointer, mPaint);
        canvas.historyPointer++;
        canvas.invalidate();
    }

    public void drawText(int w[],int h[])
    {
        //canvas.initializeTextPosition(w,h);

        //Canvas cc = new Canvas();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        //cc.drawPaint(paint);
        canvas.setMode(CanvasView.Mode.TEXT);
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        //cc.drawText("Some Text", 10, 25, paint);
        canvas.text="habikhff";
        canvas.textX=120;
        canvas.textY=120;
        canvas.fontSize=32;
       // canvas.drawText(cc);
        canvas.invalidate();
    }
}
