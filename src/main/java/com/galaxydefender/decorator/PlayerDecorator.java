package com.galaxydefender.decorator;
import com.galaxydefender.player.Player;
/** Timed decoration metadata kept separately from the player entity. */
public abstract class PlayerDecorator { protected final Player player; protected final long expiresAt; protected PlayerDecorator(Player p,long duration){player=p;expiresAt=System.currentTimeMillis()+duration;} public boolean active(){return System.currentTimeMillis()<expiresAt;} }
