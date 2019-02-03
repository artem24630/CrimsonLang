package com.example.schooler.crimsonlang;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bullet {
  private  float x,y,x0,y0,velocityY,velocityX;
  private float angle;
    Paint paint;
    public Bullet(float x0, float y0,float x, float y){
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.x0 = x0;
        this.y0 = y0;
        this.x = x;
        float g = (float) Math.sqrt((x-x0)*(x-x0) + (y-y0)*(y-y0));

        this.y = y;
        if(g<1)
            g*=10;
//        angle = (float) Math.atan2(x,y);
        float sin = (y-y0)/g;
        float cos = (x-x0)/g;
//        if(x0>x)
//        {
//            cos = -cos;
//        }
//        if(y<y0){
//            sin = -sin;
//        }

        velocityX = 5 * cos;
        velocityY = 5 * sin;
    }

    public void draw(Canvas canvas){
        canvas.drawCircle(x0,y0,5,paint);
       update(canvas);
    }

    private void update(Canvas canvas) {

        x0+=velocityX;
        y0+=velocityY;

        if(x0<0 | x0>canvas.getWidth() | y0<0 | y0>canvas.getHeight()){
           GameView.bullets.remove(this);
        }

    }

}
