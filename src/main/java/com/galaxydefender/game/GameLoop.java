package com.galaxydefender.game;
import java.awt.event.ActionListener;

import javax.swing.Timer;
public final class GameLoop { 
    private final Timer timer; 
    public GameLoop(ActionListener tick){
        timer=new Timer(16,tick);
    } 
    public void start(){
        timer.start();
    } 
    public void stop(){
        timer.stop();
    } 
}
