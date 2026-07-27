package com.galaxydefender.prototype;
import com.galaxydefender.enemy.Enemy;
/** Reusable enemy template for wave spawns. */
public final class EnemyPrototype implements Prototype<Enemy> { private final Enemy template; public EnemyPrototype(Enemy template){this.template=template;} public Enemy copy(){return template.clone();} }
