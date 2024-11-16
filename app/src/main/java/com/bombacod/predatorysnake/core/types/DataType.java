package com.bombacod.predatorysnake.core.types;

import com.bombacod.predatorysnake.core.matrix.Point;

import java.util.ArrayList;
import java.util.List;

public class DataType {
    private int index;

    public DataType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    private List<Point> points= new ArrayList<>();

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public void reset(){
        points.clear();
    }
}
