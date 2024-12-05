package com.finalproject.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.finalproject.app.GameClient;
import com.finalproject.models.Robot;
import com.finalproject.scenes.AntivirusScene;
import com.finalproject.scenes.ComputerScene;
import com.finalproject.scenes.GameScene;

public class GameController implements ActionListener {
    private GameClient client;
    private GameScene gameScene;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;


    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameClient(GameClient client) {
        this.client = client;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Computer":
                System.out.println("Computer");
                client.setScene(new ComputerScene(client, leftRobot, rightRobot, centerRobot, gameScene));

                break;
            case "Right Door":
                System.out.println("Right Door");

                break;
            case "Left Door":
                System.out.println("Left Door");
                break;
            case "Right Light":
                System.out.println("Right Light");
                break;
            case "Left Light":
                System.out.println("Left Light");
                break;
            case "Antivirus":
                client.setScene(new AntivirusScene());
                break;
            default:
                break;
        }
    }

}
