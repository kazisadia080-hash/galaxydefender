package com.galaxydefender.singleton;
/** Global session state; one manager is shared by the running game. */
public final class GameManager { private static final GameManager INSTANCE=new GameManager(); private int level=1; private boolean paused; private GameManager(){} public static GameManager getInstance(){return INSTANCE;} public int level(){return level;} public void nextLevel(){level++;} public void reset(){level=1;paused=false;} public boolean paused(){return paused;} public void togglePause(){paused=!paused;} }
