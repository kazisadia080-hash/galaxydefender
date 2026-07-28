package com.galaxydefender.game;
/** Facade retained for the requested game package; delegates state ownership to the singleton. */
public final class GameManager { private GameManager(){} public static com.galaxydefender.singleton.GameManager session(){return com.galaxydefender.singleton.GameManager.getInstance();} }
