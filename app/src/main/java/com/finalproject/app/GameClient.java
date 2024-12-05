package com.finalproject.app;

import java.awt.event.ActionListener;
import javax.swing.*;
import com.finalproject.scenes.Scene;
import com.finalproject.models.Robot;
import com.finalproject.scenes.MainMenuScene;

public class GameClient {
    private JFrame frame;
    private Scene currentScene;
    // private Robot leftRobot;
    // private Robot rightRobot;
    // private Robot centerRobot;
    
    // private ActionListener controller;

    public GameClient(JFrame frame, ActionListener controller, Robot leftRobot, Robot rightRobot, Robot centerRobot) {
        // Set up the main game window
        this.frame = frame;
        // this.leftRobot = leftRobot;
        // this.rightRobot = rightRobot;
        // this.centerRobot = centerRobot;

        // Initialize the first scene (e.g., MenuScene)
        setScene(new MainMenuScene(this, frame, controller, leftRobot, rightRobot, centerRobot));
        frame.setVisible(true);
    }

    // Method to set the active scene
    public void setScene(Scene newScene) {
        frame.getContentPane().removeAll();
        if (currentScene != null) {
            frame.remove(currentScene.getPanel()); // Remove current scene
        }
        currentScene = newScene;
        frame.add(newScene.getPanel()); // Add new scene
        frame.revalidate();
        frame.repaint();
    }
}
