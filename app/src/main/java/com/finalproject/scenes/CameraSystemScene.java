package com.finalproject.scenes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;
import com.finalproject.app.GameClient;
import com.finalproject.models.CenterRobot;
import com.finalproject.models.Robot;

public class CameraSystemScene implements Scene {
    private GameClient client;
    private GameScene gameScene;
    private JPanel cameraPanel;
    private JButton cameraButton1;
    private JButton cameraButton2;
    private JButton cameraButton3;
    private JButton cameraButton4;
    private JButton cameraButton5;
    private JButton exitButton;
    private Image cameraImage;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;

    public CameraSystemScene(GameClient client, Robot leftRobot, Robot rightRobot, Robot centerRobot, GameScene gameScene) {
        this.client = client;
        this.gameScene = gameScene;
        cameraPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Ensure the panel is cleared before drawing
                drawBackground(g); // Draw the background
            }
        };

        this.cameraButton1 = new JButton("Camera 1");
        cameraButton1.setBounds(50, 50, 100, 50);
        cameraButton1.addActionListener(e -> openCamera1());

        this.cameraButton2 = new JButton("Camera 2");
        cameraButton2.setBounds(50, 150, 100, 50);
        cameraButton2.addActionListener(e -> openCamera2());

        this.cameraButton3 = new JButton("Camera 3");
        cameraButton3.setBounds(50, 250, 100, 50);
        cameraButton3.addActionListener(e -> openCamera3());

        this.cameraButton4 = new JButton("Camera 4");
        cameraButton4.setBounds(50, 350, 100, 50);
        cameraButton4.addActionListener(e -> openCamera4());

        this.cameraButton5 = new JButton("Camera 5");
        cameraButton5.setBounds(50, 450, 100, 50);
        cameraButton5.addActionListener(e -> openCamera5());

        this.exitButton = new JButton("Exit");
        exitButton.setBounds(50, 550, 100, 50);
        exitButton.addActionListener(e -> exitCamera());
        
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;

        cameraPanel.add(cameraButton1);
        cameraPanel.add(cameraButton2);
        cameraPanel.add(cameraButton3);
        cameraPanel.add(cameraButton4);
        cameraPanel.add(cameraButton5);
        cameraPanel.add(exitButton);
    }
    
    public JPanel getPanel() {
        return cameraPanel;
    }
    
    public void openCamera1() {
        if (leftRobot.getCurrentPath() == 0) {
            //TODO: Display camera 1 image
        } else {

        }
        cameraPanel.repaint();
    }

    public void openCamera2() {
        if (((CenterRobot) centerRobot).getAngerLevel() == 1) {

        } else if (((CenterRobot) centerRobot).getAngerLevel() == 2) {

        } else if (((CenterRobot) centerRobot).getAngerLevel() == 3) {

        } else {

        }

        cameraPanel.repaint();
    }
    
    public void openCamera3() {
        if (rightRobot.getCurrentPath() == 0) {

        } else {

        }
        cameraPanel.repaint();
    }

    public void openCamera4() {
        if (leftRobot.getCurrentPath() == 1) {
        } else {
        }
        cameraPanel.repaint();
    }

    public void openCamera5() {
        if (rightRobot.getCurrentPath() == 1) {
        } else {
        }
        cameraPanel.repaint();
    }

    public void exitCamera() {
        client.setScene(gameScene);
    }

    private void drawBackground(Graphics g) {
        int panelHeight = cameraPanel.getHeight();
        int imageWidth = cameraPanel.getWidth();

        // Draw the background image with the horizontal offset
        g.drawImage(cameraImage, 0, 0, imageWidth, panelHeight, null);
    }
}
