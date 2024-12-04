package com.finalproject.scenes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class GameOverScene implements Scene{
private JPanel gameOverPanel;
    private JLabel label;

    public GameOverScene() {
        this.gameOverPanel = new GamePanel();
        this.label = new JLabel("Game Over");

        gameOverPanel.add(label);
    }
    
    public JPanel getPanel() {
        return gameOverPanel;
    }
}
