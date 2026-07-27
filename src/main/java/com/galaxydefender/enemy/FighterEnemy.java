package com.galaxydefender.enemy;
import com.galaxydefender.bullets.EnemyBullet; import java.awt.*; import java.util.*;
public final class FighterEnemy extends Enemy { public FighterEnemy(double x,double y){super(x,y,40,20);dx=2;} public void update(){y+=.4;x+=dx;if(x<0||x>856)dx=-dx;cooldown++;} public Color color(){return new Color(255,175,55);} public java.util.List<EnemyBullet> shoot(){return cooldown%105==0?java.util.List.of(new EnemyBullet(x+20,y+36)):Collections.emptyList();} }
