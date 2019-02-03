package com.example.schooler.crimsonlang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable{
   Thread gameThread;
   Hero hero;

   SurfaceHolder surfaceHolder;
   boolean running = true;
   static ArrayList<Bullet> bullets;
    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();

//        c = surfaceHolder.lockCanvas();
//        maxX = c.getWidth();
//        maxY = c.getHeight();
//        surfaceHolder.unlockCanvasAndPost(c);
        bullets = new ArrayList<>();
        gameThread = new Thread(this);
        gameThread.start();
        Log.d("msg","thread start");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
      int action = event.getAction();
      if(action == MotionEvent.ACTION_UP)
      {
        bullets.add(new Bullet(200,200,event.getX(),event.getY()));
          Log.d("msg","bullet add");

      }

        return true;
    }

    @Override
    public void run() {


        while(running){
            if(!bullets.isEmpty()){
                Canvas c = surfaceHolder.lockCanvas();

                c.drawColor(Color.WHITE);
                for (Bullet b: bullets
                     ) {
                    b.draw(c);

                }
                surfaceHolder.unlockCanvasAndPost(c);

            }

        }
    }
}
