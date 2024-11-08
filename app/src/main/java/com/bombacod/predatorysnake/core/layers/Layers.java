package com.bombacod.predatorysnake.core.layers;

public class Layers {
    private int width,height,length;
    private Layer layer0, layer1, layer2, layer3;

    public Layers(int width, int height) {
        this.width = width;
        this.height = height;
        this.length = width*height;

        layer0 = new Layer(width, height, PointIdentityImpl::new);
        layer1 = new Layer(width, height, PointIdentityImpl::new);
        layer2 = new Layer(width, height, PointTrackImpl::new);
        layer3 = new Layer(width, height, PointStaticImpl::new);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getLength() { return length; }
    public int getX(int index){ return layer0.getMatrix().getPoint(index).x; }
    public int getY(int index){ return layer0.getMatrix().getPoint(index).y; }

    public Layer getPlane0() { return layer0; }
    public Layer getPlane1() { return layer1; }
    public Layer getPlane2() { return layer2; }
    public Layer getPlane3() { return layer3; }

    ////////////
    private void updateMatrices(){
        layer0.getMatrix().processNext();
        layer1.getMatrix().processNext();
        layer2.getMatrix().processNext();
        //layer3.getMatrix().process();
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
