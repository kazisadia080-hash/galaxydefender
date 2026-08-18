package com.galaxydefender.factorymethod; 
import com.galaxydefender.enemy.Enemy;
import com.galaxydefender.enemy.ScoutEnemy;
public final class ScoutFactory implements EnemyFactory { 
    public Enemy create(double x,double y){
        return new ScoutEnemy(x,y);
    } 
}
