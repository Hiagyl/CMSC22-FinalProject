package com.finalproject.app;

import javax.swing.*;

import com.finalproject.scenes.Scene;
import com.finalproject.scenes.MainMenuScene;

public class GameClient {
    private JFrame frame;
    private Scene currentScene;

    public GameClient(JFrame frame) {
        // Set up the main game window
        this.frame = frame;

        // Initialize the first scene (e.g., MenuScene)
        setScene(new MainMenuScene(this, frame));
        frame.setVisible(true);
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
