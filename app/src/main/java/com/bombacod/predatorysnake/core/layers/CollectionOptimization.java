package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.ArrayList;
import java.util.List;

public class CollectionOptimization {
    private List<Point> list = new ArrayList<>();
    private List<Point> buffer = new ArrayList<>();

    private Matrix matrix;

    public CollectionOptimization(Matrix matrix) {
        this.matrix = matrix;
    }

    private boolean isValueAround(Point point,int zeroValue){
        for (Point point1 : point.points) {
            if(point1 != point && point1.getValue() != zeroValue){
                return true;
            }
        }
        return false;
    }

    private void isZeroAroundInCollection(Point point,int zeroValue,List<Point> collection){
        for (Point point1 : point.points) {
            if(point1 != point && point1.getValue() == zeroValue){
                point1.b = true;
                collection.add(point1);
            }
        }
    }

    public void reset(){
        list.clear();
        buffer.clear();

        for (Point point : matrix.getPoints()) {
            list.add(point);
        }
    }

    public void changeCollection(int zeroValue) {
        for (Point point : list) {
            if(point.getValue() == zeroValue){
                if(!isValueAround(point,zeroValue)){
                    point.b = false;
                    point.value[0] = zeroValue;
                    point.value[1] = zeroValue;
                    point.type[0] = 0;
                    point.type[1] = 0;
                }else{
                    point.b = true;
                    buffer.add(point);
                }
            }else
            if(point.getValue() != zeroValue){
                if(point.b){
                    point.b = false;
                    buffer.add(point);

                    isZeroAroundInCollection(point,zeroValue,buffer);
                }else{
                    point.b = false;
                    buffer.add(point);
                }
            }
        }

        List<Point> listOutdated = list;
        list = buffer;
        buffer = listOutdated;
        buffer.clear();

        for (Point point : list) {
            point.process();
        }
    }

    public void process(int zeroValue){
        if(list.size() == 0){
            reset();
        }else{
            changeCollection(zeroValue);
        }
    }

}
