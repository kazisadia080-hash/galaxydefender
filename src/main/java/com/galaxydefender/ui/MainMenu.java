package com.galaxydefender.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.galaxydefender.util.Constants;
public final class MainMenu extends JPanel {
    public MainMenu(JFrame frame){
        setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout()); 
        GridBagConstraints c=new GridBagConstraints(); 
        c.gridx=0;c.insets=new Insets(12,0,12,0); 
        JLabel title=new JLabel("GALAXY DEFENDER");
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,42));
        title.setForeground(Color.CYAN);
        c.gridy=0;add(title,c); 
        JLabel story=new JLabel("Earth is under attack. You are its last defense.");
        story.setForeground(Color.WHITE);
        c.gridy=1;
        add(story,c); 
        JButton start=new JButton("START GAME");
        start.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        start.addActionListener(e->{frame.setContentPane(new GamePanel(frame));
            frame.revalidate();
        });
        c.gridy=2;
        add(start,c); 
        JLabel keys=new JLabel("WASD Move   SPACE Shoot   P Pause   ESC Exit");
        keys.setForeground(Color.LIGHT_GRAY);
        c.gridy=3;
        add(keys,c); 
    }
}
