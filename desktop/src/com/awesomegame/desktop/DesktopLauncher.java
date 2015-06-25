package com.awesomegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.awesomegame.AwesomeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = AwesomeGame.WIDTH;
		config.height = AwesomeGame.HEIGHT;

		new LwjglApplication(new AwesomeGame(), config);
	}
}
