package com.galaxydefender.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
public final class PauseMenu extends JLabel { 
    public PauseMenu(){
        super("PAUSED",SwingConstants.CENTER);
        setFont(new Font(Font.SANS_SERIF,Font.BOLD,34));
        setForeground(Color.WHITE);
        setOpaque(true);
        setBackground(new Color(0,0,0,190));
    } 
}
