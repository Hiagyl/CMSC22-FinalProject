package com.finalproject.scenes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class WinScene implements Scene{
    private JPanel winPanel;
    private JLabel label;

    public WinScene() {
        this.winPanel = new GamePanel();
        this.label = new JLabel("You win");

        winPanel.add(label);
    }
    
    public JPanel getPanel() {
        return winPanel;
    }
}
