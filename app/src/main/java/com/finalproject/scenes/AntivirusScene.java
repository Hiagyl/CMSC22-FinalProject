package com.finalproject.scenes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class AntivirusScene implements Scene {
    private JPanel antivirusPanel;
    private JLabel label;

    public AntivirusScene() {
        this.antivirusPanel = new GamePanel();
        this.label = new JLabel("Computer Scene");

        antivirusPanel.add(label);
    }
    
    public JPanel getPanel() {
        return antivirusPanel;
    }
}
