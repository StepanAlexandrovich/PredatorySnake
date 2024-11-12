package com.bombacod.predatorysnake.core.matrix;

public class Matrix {
    private Point[] points;
    private int width,height,length;

    public Matrix(int width,int height,Next next,CreatePoint createPoint){
        this.length = (this.width = width)*(this.height = height);

        points = new Point[length];

        int index = 0;
        for(int y = 0;y<height;y++){
            for(int x = 0;x<width;x++){
                points[index] = createPoint.create(index,x,y,next);
                index++;
            }
        }

        for(int y = 0;y<height;y++){
            for(int x = 0;x<width;x++){
                getPoint(x,y).points[0] = getPoint(x,y);
                getPoint(x,y).points[1] = getPoint(x+1,y);
                getPoint(x,y).points[2] = getPoint(x,y+1);
                getPoint(x,y).points[3] = getPoint(x-1,y);
                getPoint(x,y).points[4] = getPoint(x,y-1);
            }
        }

    }

    ///////////// getPoint() /////////////////
    public int ring(int vel,int min,int max){
        if(vel<min)  { vel = vel + (max - min + 1); }
        if(vel>max)  { vel = vel - (max - min + 1); }
        return vel;
    }

    public Point getPoint(int index){
        return points[index];
    }

    public Point getPoint(int x,int y){
        return points[width*ring(y,0,height - 1) + ring(x,0,width - 1)];
    }

    public boolean isPoint(int index){ return index >=0 && index < length; }
    public boolean isPoint(int x,int y){ return isPoint(y * width + x); }

    public Point getPointCenter(int a,int b){
        return getPoint(width/2+a,height/2+b);
    }
    //////////////////////////////////////////////////

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public Point[] getPoints() {
        return points;
    }

    ////////////////////////////////////////
    public Matrix reset(){
        for (Point point : points) {
            point.reset();
        }
        return this;
    }

    public Matrix fillMatrix(int value,int type){
        for (Point point : points) {
            point.setValue(value).setType(type);
        }
        return this;
    }

    public Matrix fillMatrixExtra(int value,int type){
        for (Point point : points) {
            point.value[0] = value;
            point.value[1] = value;

            point.type[0] = type;
            point.type[1] = type;

            point.b = false;
        }
        return this;
    }

    public void process(){
        for (Point point : points) {
            point.process();
        }
    }

}
