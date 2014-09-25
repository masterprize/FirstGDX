package ñom.ussr.oldscool.electronix.logic;

import android.util.Log;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.IntMap;
import com.ussr.oldscool.electronix.game.Game;


public final class ScreenManager {
	
	public enum Screen {
	 
	    /*INTRO {
	        @Override
	        protected com.badlogic.gdx.Screen getScreenInstance() {
	            return new IntroScreen();
	        }
	    },*/
	 
	    MAIN_MENU {
	        @Override
	        protected BaseScreen getScreenInstance() {
	        	Log.d("MAIN", "MAIN");
	             return new MainScreen();
	        }
	    },
	 
	    GAME_TEST {
	        @Override
	        protected BaseScreen getScreenInstance() {
	             return new GamePlayScreen();
	        }
	    },
	 
	    Settings {
	        @Override
	        protected BaseScreen getScreenInstance() {
	             return new SettingsScreen();
	        }
	    };
	 
	    protected abstract BaseScreen getScreenInstance();
	 
	}
	
    private static ScreenManager instance;
 
    private Game game;
 
    private IntMap<BaseScreen> screens;
 
    private ScreenManager() {
        screens = new IntMap<BaseScreen>();
    }
 
    public static ScreenManager getInstance() {
        if (null == instance) {
            instance = new ScreenManager();
        }
        return instance;
    }
 
    public void initialize(Game game) {
        this.game = game;
    }
 
    public void show(Screen screen) {
       
    	if (null == game) return;
        if (!screens.containsKey(screen.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        
        game.setStage(screens.get(screen.ordinal()));
    }
 
    public void dispose(Screen screen) {
        if (!screens.containsKey(screen.ordinal())) return;
        screens.remove(screen.ordinal()).dispose();
    }
 
    public void dispose() {
        for (BaseScreen screen : screens.values()) {
            screen.dispose();
        }
        screens.clear();
        instance = null;
    }
}