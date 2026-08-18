package com.galaxydefender.enemy;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Collections;

import com.galaxydefender.bullets.EnemyBullet;
public abstract class Enemy {
    protected double x,y,dx; 
    protected int health; 
    protected final int score; 
    protected int cooldown;
    protected Enemy(double x,double y,int health,int score){
        this.x=x;
        this.y=y;
        this.health=health;
        this.score=score;
    }
    public abstract void update(); 
    public abstract Color color(); 
    public String label(){
        return getClass().getSimpleName().replace("Enemy","");
    }
    public java.util.List<EnemyBullet> shoot(){ 
        return Collections.emptyList(); 
    }
    public Rectangle bounds(){
        return new Rectangle((int)x,(int)y,44,36);
    } 
    public boolean hit(int damage){
        health-=damage;
        return health<=0;
    } 
    public int score(){
        return score;
    }
    
}
