package com.galaxydefender.game;
import javax.swing.Timer; import java.awt.event.ActionListener;
public final class GameLoop { private final Timer timer; public GameLoop(ActionListener tick){timer=new Timer(16,tick);} public void start(){timer.start();} public void stop(){timer.stop();} }
