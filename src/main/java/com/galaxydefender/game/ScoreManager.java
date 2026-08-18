package com.galaxydefender.game;
public final class ScoreManager { 
    private int score; 
    public int value(){
        return score;
    } 
    public void add(int points){
        score+=points;
    } 
}
