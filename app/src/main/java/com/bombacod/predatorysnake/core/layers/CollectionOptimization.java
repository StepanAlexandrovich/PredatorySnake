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

    public List<Point> getList() { return list; }

    private boolean isValueAround(Point point, int zeroValue){
        for (Point point1 : point.points) {
            if(point1 != point && point1.getValue() != zeroValue){
                return true;
            }
        }
        return false;
    }

    private void isZeroAroundInCollection(Point point,int zeroValue,List<Point> collection){
        for (Point point1 : point.points) {
            if(point1 != point && point1.getValue() == zeroValue && point1.mark == 0){
                point1.mark = 1;
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
                    point.mark = 0;
                    point.setValueDouble(zeroValue).setTypeDouble(0);
                }else{
                    point.mark = 1;
                    buffer.add(point);
                }
            }else
            if(point.getValue() != zeroValue){
                if(point.mark == 1){
                    point.mark = 0;
                    buffer.add(point);

                    isZeroAroundInCollection(point,zeroValue,buffer);
                }else{
                    point.mark = 0;
                    buffer.add(point);
                }
            }
        }

        List<Point> listOutdated = list;
        list = buffer;
        buffer = listOutdated;
        buffer.clear();


    }

    public void process(int zeroValue){
        if(list.size() == 0){
            reset();
        }else{
            changeCollection(zeroValue);
        }

        for (Point point : list) {
            point.process();
        }
    }

}
