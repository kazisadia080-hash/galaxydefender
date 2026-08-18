package com.galaxydefender.powerup;
import java.awt.Rectangle;
public final class PowerUp { 
    public enum Type { SHIELD, DOUBLE_DAMAGE, RAPID_FIRE, HEALTH } 
    public final Type type; 
    public double x,y; 
    public PowerUp(Type type,double x,double y){
        this.type=type;
        this.x=x;
        this.y=y;
    } 
    public void update(){
        y+=1.4;
    } 
    public Rectangle bounds(){
        return new Rectangle((int)x,(int)y,20,20);
    } 
}
