package com.galaxydefender.factorymethod; import com.galaxydefender.enemy.*;
public final class ScoutFactory implements EnemyFactory { public Enemy create(double x,double y){return new ScoutEnemy(x,y);} }
