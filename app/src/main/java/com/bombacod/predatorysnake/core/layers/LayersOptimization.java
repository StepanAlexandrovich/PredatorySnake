package com.bombacod.predatorysnake.core.layers;

import com.bombacod.predatorysnake.core.matrix.Next;

public class LayersOptimization implements Layers{
    private int width,height,length;
    private Next next;
    private Layer layer0, layer1, layer2, layer3;

    public LayersOptimization(int width, int height) {
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

    @Override
    public void reset(){
        layer0.getMatrix().fillMatrixExtra(0,0);
        layer1.getMatrix().fillMatrixExtra(0,0);
        layer2.getMatrix().fillMatrixExtra(200,0);

        layer0.getCollectionOptimization().reset();
        layer1.getCollectionOptimization().reset();
        layer2.getCollectionOptimization().reset();
    }

    ////////////
    private void updateMatrices(){
        layer0.getCollectionOptimization().process(0);
        layer1.getCollectionOptimization().process(0);
        layer2.getCollectionOptimization().process(200);
//        layer3.getMatrix().process();

        next.process();
    }

    private void updateTypes(){
        layer0.getTypes().update();
        layer1.getTypes().update();
//        layer2.getTypes().update();
//        layer3.getTypes().update();
    }

    @Override
    public void process(){
        updateMatrices();
        updateTypes();
    }

}
