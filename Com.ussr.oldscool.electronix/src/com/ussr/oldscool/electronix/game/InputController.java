package com.ussr.oldscool.electronix.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputController implements InputProcessor {

	public interface TouchColliderListener {
		
		int zIndex();
		
		boolean IsTouchEventApplyable(int screenX, int screenY);
		
		//always = even if object hidden by other by zIndex
		boolean alwaysGetTouchEvent();
		void OnTouchEvent(int screenX, int screenY);
		
	}
	
	private ArrayList<TouchColliderListener> touchDownListeners;
	private ArrayList<TouchColliderListener> touchUpListeners;
	private ArrayList<TouchColliderListener> touchDragListeners;
	
	public InputController() {
		
		Gdx.input.setInputProcessor(this);
		this.touchDownListeners = new ArrayList<TouchColliderListener>();
		this.touchUpListeners = new ArrayList<TouchColliderListener>();
		this.touchDragListeners = new ArrayList<TouchColliderListener>();
		
	}
	
	public void addTouchDownListener(TouchColliderListener listener) {
		
		this.touchDownListeners.add(listener);
		
	}
	
	public void addTouchUpListener(TouchColliderListener listener) {
		
		this.touchDownListeners.add(listener);
		
	}
	
	public void addTouchDragListener(TouchColliderListener listener) {
		
		this.touchDragListeners.add(listener);
		
	}
	
	public boolean RemoveTouchDownListener(TouchColliderListener listener) {
		
		return this.touchDownListeners.remove(listener);
		
	}
	
	public boolean RemoveTouchUpListener(TouchColliderListener listener) {
		
		return this.touchUpListeners.remove(listener);
		
	}

	public boolean RemoveTouchDragListener(TouchColliderListener listener) {
		
		return this.touchDragListeners.remove(listener);
		
	}
	
	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		this.CheckTouchEvent(this.touchDownListeners, screenX, screenY);
				
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		
		this.CheckTouchEvent(this.touchDragListeners, screenX, screenY);
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		this.CheckTouchEvent(this.touchUpListeners, screenX, screenY);
		
		return false;
	}
	
	private boolean CheckTouchEvent(ArrayList<TouchColliderListener> list, int screenX, int screenY) {
		
		boolean result = false;
		
		Iterator<TouchColliderListener> iterator = this.touchDownListeners.iterator();
		
		TouchColliderListener fListener = null;
		
		while (iterator.hasNext() == true) {
			
			TouchColliderListener listener = iterator.next();
			
			if (listener == null) continue;
			
			if (listener.IsTouchEventApplyable(screenX, screenY) == false) continue;
			
			if (fListener == null) {
			
				fListener = listener;
				
			} else {
				
				if  (listener != null) {
					
					if (listener.zIndex() < fListener.zIndex()) {
						
						fListener = listener;
						result = true;
						
					} else {
						
						if (listener.alwaysGetTouchEvent() == true) {
							
							listener.OnTouchEvent(screenX, screenY);
							result = true;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		if (fListener != null) fListener.OnTouchEvent(screenX, screenY);
			
		return result;

	}

}
