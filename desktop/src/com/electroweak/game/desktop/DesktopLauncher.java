package com.electroweak.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.electroweak.game.core.Main;

public class DesktopLauncher {

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//        config.setWindowedMode(800, 600);
        config.width = 800;
        config.height = 600;
        config.resizable = false;
        new LwjglApplication(new Main(), config);
    }

}
