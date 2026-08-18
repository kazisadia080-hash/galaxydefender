package com.galaxydefender.bullets;
import java.awt.Rectangle;
public class Bullet { 
    public double x,y,dy; 
    public final int damage; 
    public Bullet(double x,double y,double dy,int damage){
        this.x=x;
        this.y=y;
        this.dy=dy;
        this.damage=damage;
    }
    public void update(){
        y+=dy;
    }
    public Rectangle bounds(){
        return new Rectangle((int)x,(int)y,12,16);
    }
}
