package com.bombacod.predatorysnake;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogYesNo {
    public static final int NO_EVENTS = 0;
    public static final int CREATE_WINDOW = 1;
    public static final int YES = 2;
    public static final int NO = 3;
    public static int action = NO_EVENTS;

    public static void reset(){ action = NO_EVENTS; }
    public static void create(String text, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage(text)
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        action = YES;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        action = NO;
                    }
                }).show();

        action = CREATE_WINDOW;
    }

    public static int action(){
        if(action != NO_EVENTS){
            while (action == CREATE_WINDOW){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        int buffer = action;
        action = NO_EVENTS;
        return buffer;
    }

}
