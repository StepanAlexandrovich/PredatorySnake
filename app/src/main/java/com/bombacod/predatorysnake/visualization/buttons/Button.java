package com.bombacod.predatorysnake.visualization.buttons;

public class Button {
    public final int x0,y0,x1,y1;
    private boolean isClick;

    public Button(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public boolean isClick() {
        return isClick;
    }

    public void resetIsClick(){
        isClick = false;
    }

    public void process(int x, int y, Process process){
        if(x >= x0 && x <= x1 && y >= y0 && y <= y1){
            process.process();
            isClick = true;
        }
    }

}
