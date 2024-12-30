package com.bombacod.predatorysnake.pf;

import com.bombacod.predatorysnake.game.core.Model;
import com.bombacod.predatorysnake.game.visualization.top.Render;

public class StartupDownloads {
    private static Model model;
    private static Render render;

    public static void start(){
        model = new Model(Dimensions.GAME_WIDTH,Dimensions.GAME_HEIGHT);
        render = new Render();
    }
    public static synchronized Model getModel() {
        return model;
    }

    public static synchronized Render getRender() {
        return render;
    }


}
