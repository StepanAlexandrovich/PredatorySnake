package com.bombacod.predatorysnake.game.core.objects.snake;

import com.bombacod.predatorysnake.game.core.layers.Layer;
import com.bombacod.predatorysnake.game.core.layers.Layers;
import com.bombacod.predatorysnake.game.core.matrix.Point;
import com.bombacod.predatorysnake.game.core.objects.snake.body.Body;
import com.bombacod.predatorysnake.game.core.objects.snake.head.HeadEating;
import com.bombacod.predatorysnake.game.core.objects.snake.motors.Motor;

import java.util.List;

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

        // matrixObject
        headEating = new HeadEating(typeHead, layerHead);
        motor0 = new Motor(typeMotor0, layerMotors).setLowerBorder(20).setPower(500);
        motor1 = new Motor(typeMotor1, layerMotors).setLowerBorder(20).setPower(500);
        body = new Body(layerBody);

        // settings

        // the best
        headEating.setLowerBorder(100).setPower(1000)
                .setCoefficientMax(0.8)
                .setCoefficientMin(0.1);
        motor0.setLowerBorder(10).setPower(300);
        motor1.setLowerBorder(10).setPower(300);

          // good control
//        headEating.setLowerBorder(400).setPower(3000)
//                .setCoefficientMax(1.5)
//                .setCoefficientMin(0.3);
//        motor0.setLowerBorder(30).setPower(500);
//        motor1.setLowerBorder(30).setPower(500);

        // haos
//        headEating.setLowerBorder(600).setPower(5000)
//                .setCoefficientMax(1.5)
//                .setCoefficientMin(0.3);
//        motor0.setLowerBorder(20).setPower(1000);
//        motor1.setLowerBorder(20).setPower(1000);

        // fast
//        headEating.setLowerBorder(1500).setPower(8000)
//                .setCoefficientMax(2.0)
//                .setCoefficientMin(0.5);
//        motor0.setLowerBorder(10).setPower(600);
//        motor1.setLowerBorder(10).setPower(600);

        newTypeHead = new NewTypeHead();
    }

    public void start(int x,int y,String direction,int value){
        switch (direction){
            case "directly": headEating.directly(); break;
            case "right": headEating.right(); break;
            case "left": headEating.left(); break;
        }

        headEating.start(x,y,value);
        motor0.start(x - 3,y + 8,value);
        motor1.start(x + 3,y + 8,value);
    }

    public void restoreTypeHead(){ headEating.restoreType(); }

    // encapsulation
    public void right(){ headEating.right(); }
    public void left(){ headEating.left(); }
    public int getDirection(){ return headEating.getDirection(); }

    public boolean isHead(int index) { return headEating.isExisting(index); }
    public boolean isMotors(int index) { return motor0.isExisting(index) || motor1.isExisting(index); }
    public boolean isExisting(int index) { return isHead(index) || isMotors(index); }

    public boolean isLife(){ return !( !headEating.isLife() || !motor0.isLife() || !motor1.isLife() ); }

    public Point getPointHead(int index){ return layerHead.getMatrix().getPoint(index); }
    public Point getPointMotors(int index){ return layerMotors.getMatrix().getPoint(index);  }

    public List<Point> getPointsHead(){ return headEating.getPoints(); }
    public List<Point> getPointsMotor0(){ return motor0.getPoints(); }
    public List<Point> getPointsMotor1(){ return motor1.getPoints(); }

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
