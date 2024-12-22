package com.bombacod.predatorysnake.game.core.objects.snake;

import com.bombacod.predatorysnake.game.core.interfaces.PointsFunctions;
import com.bombacod.predatorysnake.game.core.matrix.Point;

public class NewTypeHead {

    public int newType(PointsFunctions head, PointsFunctions motor0, PointsFunctions motor1){
        int numberOfTypes = 20;  // refactoring
        int[] a = new int[numberOfTypes];
        int[] b = new int[numberOfTypes];

        for (Point point : motor0.getPoints()) {
            Point pointHead = head.getMatrix().getPoint(point.index);
            if(pointHead.getValue() > 0){
                a[pointHead.getType()]++;
            }
        }

        for (Point point : motor1.getPoints()) {
            Point pointHead = head.getMatrix().getPoint(point.index);
            if(pointHead.getValue() > 0){
                b[pointHead.getType()]++;
            }
        }

        for (int i = 0; i < numberOfTypes; i++) {
            if(a[i] > 0 && b[i] > 0 && head.getPoints().size() == 0){
                return i;
            }
        }

        return head.getType();
    }

}
