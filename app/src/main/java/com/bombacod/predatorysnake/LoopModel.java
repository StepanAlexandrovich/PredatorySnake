package com.bombacod.predatorysnake;

import com.bombacod.predatorysnake.core.Model;

public class LoopModel extends ThreadLoop{
    private Model model;
    private SimpleTimer timer;

    public LoopModel(Model model,int distance) {
        this.model = model;
        timer = new SimpleTimer(distance);
    }

    @Override
    public void process() {
        if(timer.process()){ // fps
            model.process();
        }
    }

}
