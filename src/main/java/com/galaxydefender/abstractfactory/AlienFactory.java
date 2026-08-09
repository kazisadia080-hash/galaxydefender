package com.galaxydefender.abstractfactory; import java.awt.Color;
public final class AlienFactory implements SpaceFactory { public Color enemyTint(){return new Color(80,230,130);} public Color bulletTint(){return Color.ORANGE;} }
