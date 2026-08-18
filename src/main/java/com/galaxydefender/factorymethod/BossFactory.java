package com.galaxydefender.factorymethod; 
import com.galaxydefender.enemy.BossEnemy;
import com.galaxydefender.enemy.Enemy;
public final class BossFactory implements EnemyFactory { 
    public Enemy create(double x,double y){
        return new BossEnemy(x,y);
    } 
}
