package com.finalproject.scenes;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.finalproject.app.GameClient;
import com.finalproject.core.GameState;
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
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;
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
        
        
        URL url = getClass().getResource("/images/ROBOT4INSERVER1.png");
        cameraImage = new ImageIcon(url).getImage();
        // cameraImage = 
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
            URL url = getClass().getResource("/images/ROBOT4INSERVER1.png");
            cameraImage = new ImageIcon(url).getImage();
        } else {
            URL url = getClass().getResource("/images/SERVERROOM.png");
            cameraImage = new ImageIcon(url).getImage();
        }
        cameraPanel.repaint();
    }

    public void openCamera2() {
        if (((CenterRobot) centerRobot).getAngerLevel() == 1) {
            URL url = getClass().getResource("/images/ROBOT3INPOWER1.png");
            cameraImage = new ImageIcon(url).getImage();
        } else if (((CenterRobot) centerRobot).getAngerLevel() == 2) {
            URL url = getClass().getResource("/images/ROBOT3INPOWER2.png");
            cameraImage = new ImageIcon(url).getImage();
        } else if (((CenterRobot) centerRobot).getAngerLevel() == 3) {
            URL url = getClass().getResource("/images/ROBOT3INPOWER3.png");
            cameraImage = new ImageIcon(url).getImage();
        } else {
            URL url = getClass().getResource("/images/ROBOT3INPOWER4.png");
            cameraImage = new ImageIcon(url).getImage();
        }

        cameraPanel.repaint();
    }
    
    public void openCamera3() {
        if (rightRobot.getCurrentPath() == 0) {
            URL url = getClass().getResource("/images/ROBOT2INSTORAGE2.png");
            cameraImage = new ImageIcon(url).getImage();
        } else {
            URL url = getClass().getResource("/images/STORAGEROOM.png");
            cameraImage = new ImageIcon(url).getImage();
        }
        cameraPanel.repaint();
    }

    public void openCamera4() {
        if (leftRobot.getCurrentPath() == 1) {
            URL url = getClass().getResource("/images/ROBOTINHALLWAYleft.png");
            cameraImage = new ImageIcon(url).getImage();
        } else {
            URL url = getClass().getResource("/images/CLEARHALLWAYleft.png");
            cameraImage = new ImageIcon(url).getImage();
        }
        cameraPanel.repaint();
    }

    public void openCamera5() {
        if (rightRobot.getCurrentPath() == 1) {
            URL url = getClass().getResource("/images/ROBOTHALLWAYright.png");
            cameraImage = new ImageIcon(url).getImage();
        } else {
            URL url = getClass().getResource("/images/CLEARHALLWAY2.png");
            cameraImage = new ImageIcon(url).getImage();
        }
        cameraPanel.repaint();
    }

    public void exitCamera() {
        GameState.setCameraOn(false);
        client.setScene(gameScene);
    }

    private void drawBackground(Graphics g) {
        int panelHeight = cameraPanel.getHeight();
        int imageWidth = cameraPanel.getWidth();

        // Draw the background image with the horizontal offset
        g.drawImage(cameraImage, 0, 0, imageWidth, panelHeight, null);
    }
}
