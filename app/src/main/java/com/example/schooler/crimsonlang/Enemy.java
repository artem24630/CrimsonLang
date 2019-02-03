package com.example.schooler.crimsonlang;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Enemy {
    private float x0,y0,xTarg,yTarg;
    Paint paint;

    public Enemy(float xTarg,float yTarg){
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        final Random random = new Random();
        x0 = random.nextFloat();
        y0 = random.nextFloat();

    }

    public void draw(Canvas c){
        c.drawCircle(x0,y0,10,paint);

    }
}
