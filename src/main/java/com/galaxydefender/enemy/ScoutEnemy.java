package com.galaxydefender.enemy;
import java.awt.*;
public final class ScoutEnemy extends Enemy { public ScoutEnemy(double x,double y){super(x,y,20,10);} public void update(){y+=.65;} public Color color(){return new Color(80,230,130);} }
