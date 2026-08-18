package com.galaxydefender.powerup;
import com.galaxydefender.player.Player;
public final class ShieldDecorator { 
    public com.galaxydefender.decorator.ShieldDecorator apply(Player player){
        return new com.galaxydefender.decorator.ShieldDecorator(player);
    } 
}
