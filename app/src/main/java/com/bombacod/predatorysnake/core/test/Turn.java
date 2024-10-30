package com.bombacod.predatorysnake.core.test;

import com.bombacod.predatorysnake.core.matrix.Matrix;

public class Turn {
    public static boolean turnHorizontal(Matrix matrix){

        for(int y = 0;y < matrix.getHeight();y++){
            for(int x = 0;x < matrix.getWidth();x++){
                int x1 = matrix.getWidth() - x - 1;
                int y1 = y;

                if(matrix.getPoint(x, y).getValue() != matrix.getPoint(x1, y1).getValue() ){
                    return false;
                }
            }
        }

        return true;
    }
}
