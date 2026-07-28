package com.galaxydefender.game;
import java.awt.Rectangle;
public final class CollisionManager { private CollisionManager(){} public static boolean intersects(Rectangle a,Rectangle b){return a.intersects(b);} }
