package com.finalproject.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.finalproject.app.GameClient;
import com.finalproject.models.Robot;
import com.finalproject.scenes.ComputerScene;
import com.finalproject.scenes.GameScene;

public class GameController implements ActionListener {
    private GameClient client;
    private GameScene gameScene;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;

    public GameController(Robot leftRobot, Robot rightRobot, Robot centerRobot) {
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;
    }

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
                GameState.setCameraOn(true);
                client.setScene(new ComputerScene(client, leftRobot, rightRobot, centerRobot, gameScene));

                break;
            case "Right Door":
                GameState.setRightDoorOpen();
                System.out.println("Right door is " + GameState.isRightDoorOpen());
                break;
            case "Left Door":
                GameState.setLeftDoorOpen();
                System.out.println("Left door is " + GameState.isLeftDoorOpen());
                break;
            case "Right Light":
                GameState.setRightLightOn();
                System.out.println("Right light is " + GameState.isRightLightOn());
                break;
            case "Left Light":
                GameState.setLeftLightOn();
                System.out.println("Left light is " + GameState.isLeftLightOn());
                break;
            case "Antivirus":
                GameState.setControlShocked();
                System.out.println("Control is " + GameState.isControlShocked());
                break;
            default:
                break;
        }
    }

}
