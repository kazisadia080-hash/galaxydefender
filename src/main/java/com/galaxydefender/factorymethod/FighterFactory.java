package com.galaxydefender.factorymethod; 
import com.galaxydefender.enemy.Enemy;
import com.galaxydefender.enemy.FighterEnemy;
public final class FighterFactory implements EnemyFactory { 
    public Enemy create(double x,double y){
        return new FighterEnemy(x,y);
    } 
}
