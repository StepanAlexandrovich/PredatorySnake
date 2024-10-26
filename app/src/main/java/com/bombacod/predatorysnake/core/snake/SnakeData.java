package com.bombacod.predatorysnake.core.snake;

import com.bombacod.predatorysnake.core.matrices.Matrices;
import com.bombacod.predatorysnake.core.matrix.Matrix;
import com.bombacod.predatorysnake.core.matrix.Point;

public class SnakeData {
    private int typeHead,typeMotor1,typeMotor2;
    private Matrices matrices;

    public SnakeData(Matrices matrices) {
        this.matrices = matrices;
    }

    public Matrices getMatrices() {
        return matrices;
    }
    // encapsulation
    public int getLength() {
        return matrices.getLength();
    }

    public Point getPointHead(int index){
        return matrices.getMatrixIdentity0().getPoint(index);
    }
    public Point getPointMotors(int index){
        return matrices.getMatrixIdentity1().getPoint(index);
    }
    public Point getPointTail(int index){
        return matrices.getMatrixTrack().getPoint(index);
    }

    public Matrix getMatrixHead(){ return matrices.getMatrixIdentity0(); }
    public Matrix getMatrixMotors(){
        return matrices.getMatrixIdentity1();
    }
    public Matrix getMatrixBody(){
        return matrices.getMatrixTrack();
    }

    // get set
    public SnakeData setTypeHead(int typeHead) {
        this.typeHead = typeHead;
        return this;
    }

    public SnakeData setTypeMotor1(int typeMotor1) {
        this.typeMotor1 = typeMotor1;
        return this;
    }

    public SnakeData setTypeMotor2(int typeMotor2) {
        this.typeMotor2 = typeMotor2;
        return this;
    }

    public int getTypeHead() {
        return typeHead;
    }
    public int getTypeMotor1() {
        return typeMotor1;
    }
    public int getTypeMotor2() {
        return typeMotor2;
    }

    // isSnake
    public boolean isHead(int index){
        Point point = matrices.getMatrixIdentity0().getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeHead);
    }

    public boolean isMotor1(int index){
        Point point = matrices.getMatrixIdentity1().getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeMotor1);
    }

    public boolean isMotor2(int index){
        Point point = matrices.getMatrixIdentity1().getPoint(index);
        return (point.getValue() > 0 && point.getType() == typeMotor2);
    }

    public boolean isMotors(int index){ return isMotor1(index) || isMotor2(index); }
//    public boolean isSnake(int index){ return isHead(index) || isMotors(index); }
    public boolean isSnake(int index){ return isMotors(index); }

}
