package com.bombacod.predatorysnake.core.matrices;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class Matrices {
    private int width,height,length;
    private Matrix matrixIdentity0, matrixIdentity1, matrixTrack;

    public Matrices(int width, int height) {
        this.width = width;
        this.height = height;
        this.length = width*height;

        matrixIdentity0 = new Matrix(width,height){
            @Override
            public Point createPoint() {
                return new PointIdentityImpl();
            }
        };

        matrixIdentity1 = new Matrix(width,height){
            @Override
            public Point createPoint() {
                return new PointIdentityImpl();
            }
        };

        matrixTrack = new Matrix(width,height){
            @Override
            public Point createPoint() {
                return new PointTrackImpl();
            }
        };
    }

    // int
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getLength() {
        return length;
    }
    public int getX(int index){ return matrixIdentity0.getPoint(index).x; }
    public int getY(int index){ return matrixIdentity0.getPoint(index).y; }

    // matrices
    public Matrix getMatrixIdentity0() {
        return matrixIdentity0;
    }
    public Matrix getMatrixIdentity1() {
        return matrixIdentity1;
    }
    public Matrix getMatrixTrack() {
        return matrixTrack;
    }

    //
    public void process(){
        matrixIdentity0.processNext();
        matrixIdentity1.processNext();
        matrixTrack.processNext();
    }

}
