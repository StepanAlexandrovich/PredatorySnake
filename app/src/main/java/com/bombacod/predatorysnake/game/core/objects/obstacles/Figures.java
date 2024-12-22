package com.bombacod.predatorysnake.game.core.objects.obstacles;

import java.util.ArrayList;
import java.util.List;

public class Figures {

    public List<Coordinate> right(int x,int y,int length){
        List<Coordinate> list = new ArrayList<>();
        for (int i = x; i < x + length; i++) {
            list.add(new Coordinate(i,y));
        }
        return list;
    }

    public List<Coordinate> down(int x,int y,int length){
        List<Coordinate> list = new ArrayList<>();
        for (int i = y; i < y + length; i++) {
            list.add(new Coordinate(x,i));
        }
        return list;
    }

    public List<Coordinate> left(int x,int y,int length){
        List<Coordinate> list = new ArrayList<>();
        for (int i = x; i > x - length; i--) {
            list.add(new Coordinate(i,y));
        }
        return list;
    }

    public List<Coordinate> up(int x,int y,int length){
        List<Coordinate> list = new ArrayList<>();
        for (int i = y; i > y - length; i--) {
            list.add(new Coordinate(x,i));
        }
        return list;
    }

    public List<Coordinate> emptyRectangle(int width,int height,int margin){
        List<Coordinate> list = new ArrayList<>();

        int newMargin = margin + 1;

        list.addAll(right(0, 0, width - newMargin));
        list.addAll(down(width - 1, 0, height - newMargin));
        list.addAll(left(width - 1, height - 1, width - newMargin));
        list.addAll(up(0, height - 1, height - newMargin));

        return list;
    }
}
