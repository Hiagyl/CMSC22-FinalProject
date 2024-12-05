package com.finalproject.scenes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class ComputerScene implements Scene {

    //TODO: Implement ComputerScene
    private JPanel computerPanel;
    private JLabel label;

    public ComputerScene() {
        this.computerPanel = new GamePanel();
        this.label = new JLabel("Computer Scene");
        //TODO: Create a display label for camera and terminal
        //TODO: Add exit button
        
        computerPanel.add(label);
    }
    
    public JPanel getPanel() {
        return computerPanel;
    }

}
