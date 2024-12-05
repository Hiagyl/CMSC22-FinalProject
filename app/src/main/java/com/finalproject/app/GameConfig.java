package com.finalproject.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import com.finalproject.core.GameController;
import com.finalproject.core.GameWindow;

public class GameConfig {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();

        JFrame gameWindow = new GameWindow(null, (int) screen.getWidth(), (int) screen.getHeight(), true, JFrame.NORMAL,
                false, true, null);

        GameController controller = new GameController();
        
        GameClient client = new GameClient(gameWindow, controller);

        controller.setGameClient(client);

    }
}
