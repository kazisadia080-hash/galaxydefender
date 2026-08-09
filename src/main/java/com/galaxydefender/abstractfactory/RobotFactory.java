package com.galaxydefender.abstractfactory; import java.awt.Color;
public final class RobotFactory implements SpaceFactory { public Color enemyTint(){return Color.LIGHT_GRAY;} public Color bulletTint(){return Color.CYAN;} }
