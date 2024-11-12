package com.bombacod.predatorysnake.core.snake;

import com.bombacod.predatorysnake.core.layers.Layer;
import com.bombacod.predatorysnake.core.layers.Layers;
import com.bombacod.predatorysnake.core.matrix.Point;
import com.bombacod.predatorysnake.core.snake.body.Body;
import com.bombacod.predatorysnake.core.snake.head.HeadEating;
import com.bombacod.predatorysnake.core.snake.motors.Motor;

public class Snake {
    private Layer layerHead, layerMotors, layerBody;

    private HeadEating headEating;
    private Motor motor0,motor1;
    private Body body;

    private NewTypeHead newTypeHead;

    public Snake(int typeHead, int typeMotor0, int typeMotor1, Layers layers) {
        layerHead = layers.getLayer0();
        layerMotors = layers.getLayer1();
        layerBody = layers.getLayer2();

        headEating = new HeadEating(typeHead, layerHead);
        headEating.setLowerBorder(400).setPower(3000);

        motor0 = new Motor(typeMotor0, layerMotors).setLowerBorder(20).setPower(500);
        motor1 = new Motor(typeMotor1, layerMotors).setLowerBorder(20).setPower(500);
        body = new Body(layerBody);

        newTypeHead = new NewTypeHead();
    }

    public void start(int x,int y,String direction){
        switch (direction){
            case "directly": headEating.directly(); break;
            case "right": headEating.right(); break;
            case "left": headEating.left(); break;
        }

        headEating.start(x,y,40000);
        motor0.start(x - 3,y + 8,10000);
        motor1.start(x + 3,y + 8,10000);
    }

    public void restoreTypeHead(){ headEating.restoreType(); }

    // encapsulation
    public void right(){ headEating.right(); }
    public void left(){ headEating.left(); }

    public boolean isHead(int index) { return headEating.isExisting(index); }
    public boolean isMotors(int index) { return motor0.isExisting(index) || motor1.isExisting(index); } // remake
    public boolean isExisting(int index) { return isHead(index) || isMotors(index); }

    public boolean isLife(){ return !( !headEating.isLife() && !motor0.isLife() && !motor1.isLife() ); }

    public Point getPointHead(int index){ return layerHead.getMatrix().getPoint(index); }
    public Point getPointMotors(int index){ return layerMotors.getMatrix().getPoint(index);  }

    public int getTypeHead(){ return headEating.getType(); }

    ////////////////////////
    public void process(){
        headEating.setType(newTypeHead.newType(headEating,motor0,motor1));

        headEating.process(motor0,motor1);
        motor0.process(headEating);
        motor1.process(headEating);
        body.process(motor0,motor1);
    }
}
