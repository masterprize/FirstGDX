package com.ussr.oldscool.electronix.game;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class Main extends AndroidApplication {

	public static Game screenController;
	
	 public void onCreate (android.os.Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         
         Main.screenController = new Game();
         initialize(Main.screenController, false);
         
	 }
	
}
