package com.galaxydefender.player;

import java.awt.*;

public class Player {
    private int x=425, y=560, health=100, lives=3;
    public boolean up, down, left, right;
    public int x(){ return x; } public int y(){ return y; } public int health(){ return health; } public int lives(){ return lives; }
    public Rectangle bounds(){ return new Rectangle(x,y,42,42); }
    public void update(){ if(left)x-=6; if(right)x+=6; if(up)y-=6; if(down)y+=6; x=Math.max(0,Math.min(858,x)); y=Math.max(260,Math.min(600,y)); }
    /** @return true when the final life is lost */
    public boolean damage(int amount){ health-=amount; if(health>0)return false; lives--; health=100; return lives<=0; }
    public void heal(){ health=Math.min(100,health+30); }
    public void resetPosition(){x=425;y=560;}
}
