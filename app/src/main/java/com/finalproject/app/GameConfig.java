package com.finalproject.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import com.finalproject.core.GameController;
import com.finalproject.core.GameWindow;
import com.finalproject.models.CenterRobot;
import com.finalproject.models.LeftRobot;
import com.finalproject.models.Robot;
import com.finalproject.models.RightRobot;

public class GameConfig {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        Robot leftRobot;
        Robot centerRobot;
        Robot rightRobot;

        JFrame gameWindow = new GameWindow(null, (int) screen.getWidth(), (int) screen.getHeight(), true, JFrame.NORMAL,
                false, true, null);

        GameController controller = new GameController();
        
        ArrayList<String> path1 = new ArrayList<String>();
        path1.add("Server Room");
        path1.add("Left Hallway");
        path1.add("Control Room");

        ArrayList<String> path2 = new ArrayList<String>();
        path2.add("Storage Room");
        path2.add("Right Hallway");
        path2.add("Control Room");

        leftRobot = new LeftRobot(path1, 5);
        rightRobot = new RightRobot(path2, 5);
        centerRobot = new CenterRobot(5);

        GameClient client = new GameClient(gameWindow, controller, leftRobot, rightRobot, centerRobot);

        leftRobot.setClient(client);
        rightRobot.setClient(client);
        centerRobot.setClient(client);
        controller.setGameClient(client);

    }
}
