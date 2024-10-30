package com.bombacod.predatorysnake.core.snake;

import com.bombacod.predatorysnake.core.matrices.Matrices;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.tail.Tail;
import com.bombacod.predatorysnake.core.snake.head.Head;
import com.bombacod.predatorysnake.core.snake.motors.Motors;

public class Snake {
    private SnakeData snakeData;

    private Head head;
    private Motors motors;
    private Tail tail;

    public Snake(Matrices matrices,int typeMotor1,int typeMotor2) {
        snakeData = new SnakeData(matrices).setTypeMotor1(typeMotor1).setTypeMotor2(typeMotor2);

        head = new Head(snakeData);
        motors = new Motors(snakeData);
        tail = new Tail(snakeData);
    }

    public void start(int x,int y,String direction){
        if(direction == "left"){
            head.left();
        }else
        if(direction == "right"){
            head.right();
        }else
        if(direction == "directly"){
            head.directly();
        }

        head.start(x,y,40000,1);

        motors.start(x - 3,y + 8,10000,snakeData.getTypeMotor1());
        motors.start(x + 3,y + 8,7000,snakeData.getTypeMotor2());
    }

    // encapsulation
    public void right(){ head.right(); }
    public void left(){ head.left(); }

    public boolean isHead(int index) { return snakeData.isHead(index); }
    public boolean isMotors(int index) { return snakeData.isMotors(index); }
    public boolean isSnake(int index) { return snakeData.isSnake(index); }

    public Point getPointHead(int index){
        return snakeData.getPointHead(index);
    }
    public Point getPointMotors(int index){
        return snakeData.getPointMotors(index);
    }

    public int getTypeHead(){ return snakeData.getTypeHead(); }

    private int newTypeHead(){
        int length = snakeData.getLength();

        int numberOfTypes = 20;  // refactoring
        int[] a = new int[numberOfTypes];
        int[] b = new int[numberOfTypes];
        for (int i = 0; i < length; i++) {
            Point pointHead = snakeData.getPointHead(i);


            if(snakeData.isMotor1(i) && pointHead.getValue() > 0){
                a[pointHead.getType()]++;
            }else
            if(snakeData.isMotor2(i) && pointHead.getValue() > 0){
                b[pointHead.getType()]++;
            }
        }

        for (int i = 0; i < numberOfTypes; i++) {
            if(a[i] > 0 && b[i] > 0 && i == snakeData.getTypeHead()){
                return i;
            }
        }

        for (int i = 0; i < numberOfTypes; i++) {
            if(a[i] > 0 && b[i] > 0){
                return i;
            }
        }

        return snakeData.getTypeHead();
    }

    ////////////////////////
    public void process(){
        snakeData.setTypeHead(newTypeHead());

        head.process();
        motors.process();
        tail.process();
    }
}
