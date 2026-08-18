package com.galaxydefender.game;
public final class GameManager { 
    private GameManager(){}
    public static com.galaxydefender.singleton.GameManager session(){
        return com.galaxydefender.singleton.GameManager.getInstance();
    }
}
