package com.bombacod.predatorysnake;

import android.app.AlertDialog;
import android.content.Context;

public class VisualizationHelpers {

    public static void dialog(String text, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(text);
        builder.setMessage(text);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
