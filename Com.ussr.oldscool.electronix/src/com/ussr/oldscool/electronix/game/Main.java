package com.ussr.oldscool.electronix.game;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class Main extends AndroidApplication {

	 public void onCreate (android.os.Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         initialize(new Gameplay(), false);
	 }
	
}
