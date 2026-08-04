package com.galaxydefender.powerup;
import com.galaxydefender.player.Player;
/** Compatibility façade for the decorator implementation package. */
public final class ShieldDecorator { public com.galaxydefender.decorator.ShieldDecorator apply(Player player){return new com.galaxydefender.decorator.ShieldDecorator(player);} }
