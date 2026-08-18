package com.galaxydefender.factorymethod; 
import com.galaxydefender.enemy.Enemy;
import com.galaxydefender.enemy.HeavyEnemy;
public final class HeavyFactory implements EnemyFactory { 
    public Enemy create(double x,double y){
        return new HeavyEnemy(x,y);
    } 
}
