package com.finalproject.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.Desktop.Action;

import javax.swing.JFrame;

import com.finalproject.core.Controller;
import com.finalproject.core.GameWindow;


public class GameConfig {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();

        JFrame gameWindow = new GameWindow(null, (int) screen.getWidth(), (int) screen.getHeight(), true, JFrame.NORMAL,
                false, true, null);
        Controller controller = new Controller();
        // MainMenuScene scene = new MainMenuScene(gameWindow);
        // gameWindow.setVisible(true);

        GameClient client = new GameClient(gameWindow);

        controller.setGameClient(client);
        client.setController(controller);
        
    }
}
