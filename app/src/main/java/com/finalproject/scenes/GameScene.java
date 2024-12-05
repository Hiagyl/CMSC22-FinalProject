package com.finalproject.scenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.finalproject.app.GameClient;
import com.finalproject.core.Battery;
import com.finalproject.core.GameController;
import com.finalproject.core.Time;
import com.finalproject.models.Robot;

public class GameScene implements Scene {
    private JPanel gamePanel;
    private JLabel time;
    // private MainMenuScene menu;
    private JLabel battery;
    private Time timeThread;
    private Battery batteryThread;
    private JButton computerButton;
    private JButton rightDoorButton;
    private JButton leftDoorButton;
    // private JButton rightLightButton;
    // private JButton leftLightButton;
    private JButton shockButton;
    private Image backgroundImage;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;

    private int backgroundX; // Horizontal offset for the background
    private int scrollSpeed = 20; // Speed of scrolling

    // Store initial button positions
    private int computerButtonX = 800;
    private int rightDoorButtonX = 1300;
    private int leftDoorButtonX = 0;
    // private int rightLightButtonX = 100;
    // private int leftLightButtonX = 100;
    private int shockButtonX = 600;

    public GameScene(GameClient client, JFrame window, GameController controller, Robot leftRobot, Robot rightRobot,
            Robot centerRobot, MainMenuScene menu) {
        // this.menu = menu;

        controller.setGameScene(this);
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Ensure the panel is cleared before drawing
                drawBackground(g); // Draw the background
            }
        };
        gamePanel.setLayout(null);
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
        timeThread = new Time(time, client, menu, this);
        Thread thread1 = new Thread(timeThread);
        thread1.start();
        
        battery = new JLabel("Battery: 100%");
        battery.setBounds(200, 0, 100, 50);
        gamePanel.add(battery);
        batteryThread = Battery.getInstance(battery);
        Thread thread2 = new Thread(batteryThread);
        thread2.start();
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;

        this.leftRobot.startThread();
        this.rightRobot.startThread();
        this.centerRobot.startThread();

        computerButton = new JButton("Computer");
        computerButton.setActionCommand("Computer");
        computerButton.setPreferredSize(new Dimension(200, 50));
        computerButton.setBounds(computerButtonX, 600, 200, 50);
        computerButton.addActionListener(controller);
        gamePanel.add(computerButton);

        rightDoorButton = new JButton("Door Open");
        rightDoorButton.setActionCommand("Right Door");
        rightDoorButton.setPreferredSize(new Dimension(200, 50));
        rightDoorButton.setBounds(rightDoorButtonX, 50, 200, 50);
        rightDoorButton.addActionListener(controller);
        gamePanel.add(rightDoorButton);

        leftDoorButton = new JButton("Door Open");
        leftDoorButton.setActionCommand("Left Door");
        leftDoorButton.setPreferredSize(new Dimension(200, 50));
        leftDoorButton.setBounds(leftDoorButtonX, 50, 200, 50);
        leftDoorButton.addActionListener(controller);
        gamePanel.add(leftDoorButton);

        // rightLightButton = new JButton("Right Light");
        // rightLightButton.setActionCommand("Right Light");
        // rightLightButton.setPreferredSize(new Dimension(100, 50));
        // rightLightButton.setBounds(rightLightButtonX, 400, 100, 50);
        // rightLightButton.addActionListener(controller);
        // gamePanel.add(rightLightButton);

        // leftLightButton = new JButton("Left Light");
        // leftLightButton.setActionCommand("Left Light");
        // leftLightButton.setPreferredSize(new Dimension(100, 50));
        // leftLightButton.setBounds(leftLightButtonX, 500, 100, 50);
        // leftLightButton.addActionListener(controller);
        // gamePanel.add(leftLightButton);

        shockButton = new JButton("Shock Deactivated");
        shockButton.setActionCommand("Shock");
        shockButton.setPreferredSize(new Dimension(200, 50));
        shockButton.setBounds(shockButtonX, 600, 200, 50);
        shockButton.addActionListener(controller);
        gamePanel.add(shockButton);

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
        int minScrollX = -(imageWidth - panelWidth); // Right limit (fully aligned to the right)

        int newBackgroundX = backgroundX; // Start with the current backgroundX

        if (mouseX < threshold) {
            // Cursor is near the left edge, scroll to the left
            newBackgroundX += scrollSpeed;
        } else if (mouseX > panelWidth - threshold) {
            // Cursor is near the right edge, scroll to the right
            newBackgroundX -= scrollSpeed;
        }

        // Clamp the newBackgroundX to prevent scrolling out of bounds
        newBackgroundX = Math.max(minScrollX, Math.min(newBackgroundX, maxScrollX));

        // Update backgroundX only if it has changed
        if (newBackgroundX != backgroundX) {
            backgroundX = newBackgroundX;
            // Update button positions based on backgroundX
            updateButtonPositions();
            // Repaint the panel to show the updated background position
            gamePanel.repaint();
        }

        // System.out.println("backgroundX: " + backgroundX + " minScrollX: " + minScrollX + " maxScrollX: " + maxScrollX);
    }

    private void updateButtonPositions() {
        computerButton.setBounds(computerButtonX + backgroundX, 600, 200, 50);
        rightDoorButton.setBounds(rightDoorButtonX + backgroundX, 50, 200, 50);
        leftDoorButton.setBounds(leftDoorButtonX + backgroundX, 50, 200, 50);
        shockButton.setBounds(shockButtonX + backgroundX, 600, 200, 50);
    }

    public void stopAllThreads() {
        timeThread.stop();
        batteryThread.stop();
        leftRobot.stop();
        rightRobot.stop();
        centerRobot.stop();
    }
    
}