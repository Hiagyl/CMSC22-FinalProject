package com.finalproject.scenes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class SurvivedScene implements Scene {
    private JPanel survivedPanel;
    private JLabel label;

    public SurvivedScene() {
        this.survivedPanel = new GamePanel();
        this.label = new JLabel("Night Survived");

        survivedPanel.add(label);
    }
    
    public JPanel getPanel() {
        return survivedPanel;
    }
}       
