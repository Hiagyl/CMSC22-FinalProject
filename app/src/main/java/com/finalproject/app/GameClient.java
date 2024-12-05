package com.finalproject.app;

import java.awt.event.ActionListener;
import javax.swing.*;
import com.finalproject.scenes.Scene;
import com.finalproject.scenes.MainMenuScene;

public class GameClient {
    private JFrame frame;
    private Scene currentScene;
    private ActionListener controller;

    public GameClient(JFrame frame) {
        // Set up the main game window
        this.frame = frame;

        // Initialize the first scene (e.g., MenuScene)
        setScene(new MainMenuScene(this, controller));
        frame.setVisible(true);
    }

    public void setController(ActionListener controller) {
        this.controller = controller;
    }

    // Method to set the active scene
    public void setScene(Scene newScene) {
        if (currentScene != null) {
            frame.remove(currentScene.getPanel()); // Remove current scene
        }
        currentScene = newScene;
        frame.add(currentScene.getPanel()); // Add new scene
        frame.revalidate();
        frame.repaint();
    }
}
