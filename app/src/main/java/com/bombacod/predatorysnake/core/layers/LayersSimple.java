package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Next;

public class LayersSimple implements Layers{
    private int width,height,length;
    private Next next;
    private Layer layer0, layer1, layer2, layer3;

    public LayersSimple(int width, int height) {
        this.width = width;
        this.height = height;
        this.length = width*height;

        next = new Next();

        layer0 = new Layer(width, height, next, PointIdentityImpl::new);
        layer1 = new Layer(width, height, next, PointIdentityImpl::new);
        layer2 = new Layer(width, height, next, PointTrackImpl::new);
        layer3 = new Layer(width, height, next, PointStaticImpl::new);
    }

    @Override
    public int getWidth() { return width; }
    @Override
    public int getHeight() { return height; }
    @Override
    public int getLength() { return length; }
    @Override
    public int getX(int index){ return layer0.getMatrix().getPoint(index).x; }
    @Override
    public int getY(int index){ return layer0.getMatrix().getPoint(index).y; }

    @Override
    public Layer getLayer0() { return layer0; }
    @Override
    public Layer getLayer1() { return layer1; }
    @Override
    public Layer getLayer2() { return layer2; }
    @Override
    public Layer getLayer3() { return layer3; }


    public void reset(){
        layer0.getMatrix().fillMatrix(0,0);
        layer1.getMatrix().fillMatrix(0,0);
        layer2.getMatrix().fillMatrix(200,0);
    }

    ////////////
    private void updateMatrices(){
        layer0.getMatrix().process();
        layer1.getMatrix().process();
        layer2.getMatrix().process();
//        layer3.getMatrix().process();

        next.process();
    }

    private void updateTypes(){
        layer0.getTypes().update();
        layer1.getTypes().update();
//        layer2.getTypes().update();
//        layer3.getTypes().update();
    }

    public void process(){
        updateMatrices();
        updateTypes();
    }

}
