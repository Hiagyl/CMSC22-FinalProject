package com.finalproject.scenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameScene implements Scene {
    // private JFrame window;
    // private GameClient client;
    private JPanel gamePanel;
    private JLabel time;
    private JButton computerButton;
    private JButton rightDoorButton;
    private JButton leftDoorButton;
    private JButton rightLightButton;
    private JButton leftLightButton;
    private JButton antivirusButton;
    private Image backgroundImage;
    private int backgroundX; // Horizontal offset for the background
    private int scrollSpeed = 20; // Speed of scrolling

    // Store initial button positions
    private int computerButtonX = 100;
    private int rightDoorButtonX = 100;
    private int leftDoorButtonX = 100;
    private int rightLightButtonX = 100;
    private int leftLightButtonX = 100;
    private int antivirusButtonX = 100;

    public GameScene(ActionListener controller) {
        // this.client = client;
        // this.window = window;

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Ensure the panel is cleared before drawing
                drawBackground(g); // Draw the background
            }
        };

        // Initialize background position
        backgroundX = 0;

        // Load the background image
        URL url = getClass().getResource("/images/bg1.png");
        backgroundImage = new ImageIcon(url).getImage();

        // Add mouse motion listener to detect cursor position
        gamePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                handleMouseMove(e.getX());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseMove(e.getX());
            }
        });

        time = new JLabel("Time: 0");
        time.setBounds(100, 0, 100, 50);
        gamePanel.add(time);

        computerButton = new JButton("Computer");
        computerButton.setActionCommand("Computer");
        computerButton.setPreferredSize(new Dimension(100, 50));
        computerButton.setBounds(computerButtonX, 100, 100, 50);
        computerButton.addActionListener(controller);
        gamePanel.add(computerButton);

        rightDoorButton = new JButton("Right Door");
        rightDoorButton.setPreferredSize(new Dimension(100, 50));
        rightDoorButton.setBounds(rightDoorButtonX, 200, 100, 50);
        rightDoorButton.addActionListener(controller);
        gamePanel.add(rightDoorButton);

        leftDoorButton = new JButton("Left Door");
        leftDoorButton.setPreferredSize(new Dimension(100, 50));
        leftDoorButton.setBounds(leftDoorButtonX, 300, 100, 50);
        leftDoorButton.addActionListener(controller);
        gamePanel.add(leftDoorButton);

        rightLightButton = new JButton("Right Light");
        rightLightButton.setPreferredSize(new Dimension(100, 50));
        rightLightButton.setBounds(rightLightButtonX, 400, 100, 50);
        rightLightButton.addActionListener(controller);
        gamePanel.add(rightLightButton);

        leftLightButton = new JButton("Left Light");
        leftLightButton.setPreferredSize(new Dimension(100, 50));
        leftLightButton.setBounds(leftLightButtonX, 500, 100, 50);
        leftLightButton.addActionListener(controller);
        gamePanel.add(leftLightButton);

        antivirusButton = new JButton("Antivirus");
        antivirusButton.setPreferredSize(new Dimension(100, 50));
        antivirusButton.setBounds(antivirusButtonX, 600, 100, 50);
        antivirusButton.addActionListener(controller);
        gamePanel.add(antivirusButton);

        gamePanel.setLayout(null);
        gamePanel.setVisible(true);
    }

    @Override
    public JPanel getPanel() {
        return gamePanel;
    }

    private void drawBackground(Graphics g) {
        int panelHeight = gamePanel.getHeight();
        int imageWidth = backgroundImage.getWidth(null);

        // Draw the background image with the horizontal offset
        g.drawImage(backgroundImage, backgroundX, 0, imageWidth, panelHeight, null);
    }

    private void handleMouseMove(int mouseX) {
        int threshold = 50; // Threshold from the edge to trigger scrolling
        int panelWidth = gamePanel.getWidth();
        int imageWidth = backgroundImage.getWidth(null);
        int maxScrollX = 0; // Left limit (fully aligned to the left)
        int minScrollX = -(imageWidth - panelWidth);

        if (mouseX < threshold) {
            // Cursor is near the left edge, scroll to the left
            backgroundX += scrollSpeed;
        } else if (mouseX > panelWidth - threshold) {
            // Cursor is near the right edge, scroll to the right
            backgroundX -= scrollSpeed;
            
        }

        // Clamp the backgroundX to prevent scrolling out of bounds
        // Right limit (fully aligned to the right)
        backgroundX = Math.max(minScrollX, Math.min(backgroundX, maxScrollX));

        // Update button positions based on backgroundX
        updateButtonPositions();

        // Repaint the panel to show the updated background position
        gamePanel.repaint();
    }

    private void updateButtonPositions() {
        computerButton.setBounds(computerButtonX + backgroundX, 100, 100, 50);
        rightDoorButton.setBounds(rightDoorButtonX + backgroundX, 200, 100, 50);
        leftDoorButton.setBounds(leftDoorButtonX + backgroundX, 300, 100, 50);
        rightLightButton.setBounds(rightLightButtonX + backgroundX, 400, 100, 50);
        leftLightButton.setBounds(leftLightButtonX + backgroundX, 500, 100, 50);
        antivirusButton.setBounds(antivirusButtonX + backgroundX, 600, 100, 50);
    }
}