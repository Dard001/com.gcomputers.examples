package com.rpg.libgdx.stuff.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rpg.libgdx.game.MyGdxGame;

public class DesktopLauncher {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "2D Game";
                config.useGL30 = true;
                config.height = HEIGHT;
                config.width = WIDTH;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
