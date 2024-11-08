package com.bombacod.predatorysnake.core.snake;

import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.layers.Layer;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.types.DataType;

import java.util.List;

public class DataSnake {
    private int typeHead, typeMotor0, typeMotor1;
    private int[]typeMotors;

    private Layers layers;
    private Matrix matrixHead,matrixMotors,matrixBody;

    private DataType dataTypeHead, dataTypeMotor0, dataTypeMotor1;
    private DataType[] dataTypeMotors;

    public DataSnake(int typeHead, int typeMotor0, int typeMotor1, Layers layers) {
        this.typeHead = typeHead;
        this.typeMotor0 = typeMotor0;
        this.typeMotor1 = typeMotor1;
        typeMotors = new int[]{typeMotor0,typeMotor1};

        this.layers = layers;
        matrixHead = layers.getPlane0().getMatrix();
        matrixMotors = layers.getPlane1().getMatrix();
        matrixBody = layers.getPlane2().getMatrix();

        dataTypeHead = getPlaneHead().getTypes().getType( typeHead);
        dataTypeMotor0 = getPlaneMotors().getTypes().getType( typeMotor0 );
        dataTypeMotor1 = getPlaneMotors().getTypes().getType( typeMotor1 );
        dataTypeMotors = new DataType[]{dataTypeMotor0, dataTypeMotor1};
    }

    // get set
    public int getTypeHead() {
        return typeHead;
    }
    public int getTypeMotor0() {
        return typeMotor0;
    }
    public int getTypeMotor1() {
        return typeMotor1;
    }
    public int getTypeMotors(int index) { return typeMotors[index]; }

    public DataSnake setTypeHead(int typeHead) {
        this.typeHead = typeHead;
        dataTypeHead = getPlaneHead().getTypes().getType( typeHead);
        return this;
    }

    // encapsulation planes
    public int getLength() {
        return layers.getLength();
    }
    public Layer getPlaneHead(){ return layers.getPlane0(); }
    public Layer getPlaneMotors(){ return layers.getPlane1(); }
    public Layer getPlaneBody(){ return layers.getPlane2(); }

    public List<Point> getPointsHead(){ return dataTypeHead.getPoints(); }
    public List<Point> getPointsMotor0(){ return dataTypeMotor0.getPoints(); }
    public List<Point> getPointsMotor1(){ return dataTypeMotor1.getPoints(); }
    public List<Point> getPointsMotor(int index){ // index = 0 -> motor0; index = 1 -> motor1;
        return dataTypeMotors[index].getPoints();
    }

    public Point[] getPointsBody(){ return getPlaneBody().getMatrix().getPoints(); }

    public Matrix getMatrixHead(){ return matrixHead; }
    public Matrix getMatrixMotors(){
        return matrixMotors;
    }
    public Matrix getMatrixBody(){
        return matrixBody;
    }

    public Point getPointHead(int index){
        return matrixHead.getPoint(index);
    }
    public Point getPointMotors(int index){
        return matrixMotors.getPoint(index);
    }
    public Point getPointBody(int index){
        return matrixBody.getPoint(index);
    }

    // isSnake
    public boolean isHead(int index){
        Point point = matrixHead.getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeHead);
    }

    public boolean isMotor1(int index){
        Point point = matrixMotors.getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeMotor0);
    }

    public boolean isMotor2(int index){
        Point point = matrixMotors.getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeMotor1);
    }

    public boolean isMotors(int index){ return isMotor1(index) || isMotor2(index); }
    public boolean isSnake(int index){ return isMotors(index); }
    //    public boolean isSnake(int index){ return isHead(index) || isMotors(index); } // standard

    // isLife
    public boolean isLifeHead(){ return getPointsHead().size() != 0; }
    public boolean isLifeMotor0(){ return getPointsMotor0().size() != 0; }
    public boolean isLifeMotor1(){ return getPointsMotor1().size() != 0; }

    public boolean isLife(){ return !( !isLifeHead() && !isLifeMotor0() && !isLifeMotor1() ); }
}
