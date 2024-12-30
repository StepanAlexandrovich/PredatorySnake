package com.bombacod.predatorysnake.pf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bombacod.predatorysnake.R;

public class Images {
    private static Bitmap restart;
//    private static Bitmap defeat;
    private static Bitmap timeIsUp;
    private static Bitmap death;
    private static Bitmap win;
    private static Bitmap control;
    private static Bitmap controlLeft;
    private static Bitmap controlRight;

    public static void start(Context context){
        restart = BitmapFactory.decodeResource(context.getResources(),R.drawable.restart);  // bad decision
//        defeat = BitmapFactory.decodeResource(context.getResources(),R.drawable.defeat);  // bad decision
        death = BitmapFactory.decodeResource(context.getResources(),R.drawable.death);  // bad decision
        timeIsUp = BitmapFactory.decodeResource(context.getResources(),R.drawable.time_is_up);  // bad decision

        win = BitmapFactory.decodeResource(context.getResources(),R.drawable.win);  // bad decision
        control = BitmapFactory.decodeResource(context.getResources(),R.drawable.control);  // bad decision
        controlLeft = BitmapFactory.decodeResource(context.getResources(),R.drawable.left);  // bad decision
        controlRight = BitmapFactory.decodeResource(context.getResources(),R.drawable.right);  // bad decision
    }

    public static Bitmap getRestart() { return restart; }
//    public static Bitmap getDefeat() { return defeat; }

    public static Bitmap getTimeIsUp() { return timeIsUp; }
    public static Bitmap getDeath() { return death; }

    public static Bitmap getWin() { return win; }
    public static Bitmap getControl() { return control; }

    public static Bitmap getControlLeft() { return controlLeft; }
    public static Bitmap getControlRight() { return controlRight; }
}
