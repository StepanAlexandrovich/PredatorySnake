package com.bombacod.predatorysnake.core.snake;

import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.snake.body.Body;
import com.bombacod.predatorysnake.core.snake.head.Head;
import com.bombacod.predatorysnake.core.snake.motors.Motor;

public class Snake {
    private DataSnake data;

    private Head head;
    private Motor motor0,motor1;
    private Body body;

    public Snake(int typeHead, int typeMotor1, int typeMotor2, Layers layers) {
        data = new DataSnake(typeHead,typeMotor1,typeMotor2, layers);

        head = new Head(data).setLowerBorder(400).setPower(3000);
        motor0 = new Motor(0,data).setLowerBorder(20).setPower(500);
        motor1 = new Motor(1,data).setLowerBorder(20).setPower(500);
        body = new Body(data);
    }

    public void start(int x,int y,String direction){
        switch (direction){
            case "directly": head.directly(); break;
            case "right": head.right(); break;
            case "left": head.left(); break;
        }

        head.start(x,y,40000);
        motor0.start(x - 3,y + 8,10000);
        motor1.start(x + 3,y + 8,10000);
    }

    // encapsulation
    public void right(){ head.right(); }
    public void left(){ head.left(); }

    public boolean isHead(int index) { return data.isHead(index); }
    public boolean isMotors(int index) { return data.isMotors(index); }
    public boolean isSnake(int index) { return data.isSnake(index); }

    public boolean isLife(){ return data.isLife(); }

    public Point getPointHead(int index){
        return data.getPointHead(index);
    }
    public Point getPointMotors(int index){
        return data.getPointMotors(index);
    }

    public int getTypeHead(){ return data.getTypeHead(); }

    private int newTypeHead(){
        int length = data.getLength();

        int numberOfTypes = 20;  // refactoring
        int[] a = new int[numberOfTypes];
        int[] b = new int[numberOfTypes];
        for (int i = 0; i < length; i++) {
            Point pointHead = data.getPointHead(i);

            if(data.isMotor1(i) && pointHead.getValue() > 0){
                a[pointHead.getType()]++;
            }else
            if(data.isMotor2(i) && pointHead.getValue() > 0){
                b[pointHead.getType()]++;
            }
        }

        for (int i = 0; i < numberOfTypes; i++) {
            if(a[i] > 0 && b[i] > 0 && i == data.getTypeHead()){
                return i;
            }
        }

        for (int i = 0; i < numberOfTypes; i++) {
            if(a[i] > 0 && b[i] > 0){
                return i;
            }
        }

        return data.getTypeHead();
    }

    ////////////////////////
    public void process(){
        data.setTypeHead(newTypeHead());

        head.process();
        motor0.process();
        motor1.process();
        body.process();
    }
}
