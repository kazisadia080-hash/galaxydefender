package com.galaxydefender.adapter;
/** Placeholder adapter for a future controller library; it shares the keyboard command vocabulary. */
public final class ControllerAdapter implements InputAdapter { private final InputAdapter target; public ControllerAdapter(InputAdapter target){this.target=target;} public void pressed(int key){target.pressed(key);} public void released(int key){target.released(key);} }
