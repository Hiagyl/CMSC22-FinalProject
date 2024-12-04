package com.finalproject.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    private int screenWidth;
    private int screenHeight;

    public GameWindow(String title, int width, int height, boolean isUndecorated, int extendedState,
            boolean isResizable, boolean isAlwaysOnTop, ImageIcon logo) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(isResizable);
        this.setSize(width, height);
        this.setUndecorated(isUndecorated);
        this.setExtendedState(extendedState);
        this.getContentPane().setBackground(Color.BLACK);
        this.setAlwaysOnTop(isAlwaysOnTop);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Width and height of the screen
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //TODO: Add keyListener

    }
    
    public int getWidth() {
        return screenWidth;
    }

    public int getHeight() {
        return screenHeight;
    }
} 