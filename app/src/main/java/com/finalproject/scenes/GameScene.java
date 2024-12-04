package com.finalproject.scenes;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.app.GameClient;

public class GameScene implements Scene {
    private JFrame window;
    private GameClient client;
    private JPanel gamePanel;
    private JLabel time;
    private JButton computerButton;
    private JButton antivirusButton;
    private JButton rightDoorButton;
    private JButton leftDoorButton;
    private JButton rightDoorLight;
    private JButton leftDoorLight;
    private Image backgroundImage;
    
    public GameScene(GameClient client, JFrame window) {
        this.client = client;
        this.window = window;

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);  // Ensure the panel is cleared before drawing
                drawBackground(g);        // Draw the background
            }
        };

        gamePanel.setVisible(true);

        URL url = getClass().getResource("/images/bg1.png");
        backgroundImage = new ImageIcon(url).getImage();

        //TODO: ADD BUTTONS
    }

    @Override
    public JPanel getPanel() {
        return gamePanel;
    }

    public void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, -100, 0, window.getWidth()+100, window.getHeight(), null);
    }

}
