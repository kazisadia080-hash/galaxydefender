package com.galaxydefender.factorymethod; import com.galaxydefender.enemy.*;
public final class FighterFactory implements EnemyFactory { public Enemy create(double x,double y){return new FighterEnemy(x,y);} }
