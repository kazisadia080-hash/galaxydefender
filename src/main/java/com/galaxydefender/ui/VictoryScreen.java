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
import javax.swing.SwingConstants;
public final class VictoryScreen extends JPanel { 
    public VictoryScreen(JFrame frame,int score){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900,650));
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        JLabel message=new JLabel("<html><div style='text-align:center'>CONGRATULATIONS!<br>MISSION COMPLETE<br>EARTH IS SAVED!<br><br>Final Score: "+score+"</div></html>",SwingConstants.CENTER);
        message.setForeground(Color.GREEN);
        message.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        c.gridy=0;
        add(message,c);
        JButton again=new JButton("PLAY AGAIN");
        again.addActionListener(e->{frame.setContentPane(new MainMenu(frame));frame.revalidate();});
        c.gridy=1;
        c.insets=new Insets(25,0,0,0);
        add(again,c);
    }
}
