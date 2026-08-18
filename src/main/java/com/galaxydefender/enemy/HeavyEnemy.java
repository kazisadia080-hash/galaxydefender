package com.galaxydefender.enemy;
import java.awt.Color;
import java.util.Collections;

import com.galaxydefender.bullets.EnemyBullet;
public final class HeavyEnemy extends Enemy { 
    public HeavyEnemy(double x,double y){
        super(x,y,70,40);
    } 
    public void update(){
        y+=.22;
        cooldown++;
    } 
    public Color color(){
        return new Color(210,75,235);
    } 
    public java.util.List<EnemyBullet> shoot(){
        if(cooldown%135!=0)return Collections.emptyList();
        return java.util.List.of(new EnemyBullet(x+5,y+36),new EnemyBullet(x+20,y+36),new EnemyBullet(x+35,y+36));
    } 
}
