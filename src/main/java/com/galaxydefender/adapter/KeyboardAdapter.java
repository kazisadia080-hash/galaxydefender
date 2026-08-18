package com.galaxydefender.adapter;
import com.galaxydefender.ui.GamePanel;public final class KeyboardAdapter implements InputAdapter { 
    private final GamePanel game; 
    public KeyboardAdapter(GamePanel game){
        this.game=game;
    } 
    public void pressed(int key){
        game.handleKey(key,true);
    } 
    public void released(int key){
        game.handleKey(key,false);
    } 
}
