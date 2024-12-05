package com.finalproject.scenes;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.finalproject.app.GameClient;
import com.finalproject.core.GamePanel;
import com.finalproject.core.GameState;
import com.finalproject.models.Robot;

public class ComputerScene implements Scene {

    private GameClient client;
    // private JFrame window;
    private GameScene gameScene;
    private JPanel computerPanel;
    private JButton cameraSystem;
    // private JButton terminal;
    private JButton exitButton;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;
    

    public ComputerScene(GameClient client, Robot leftRobot, Robot rightRobot, Robot centerRobot, GameScene gameScene) {
        this.client = client;
        // this.window = window;
        this.gameScene = gameScene;
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;
        
        this.computerPanel = new GamePanel();
        this.cameraSystem = new JButton("Camera System");
        cameraSystem.setActionCommand("Camera System");
        cameraSystem.setPreferredSize(new Dimension(100, 50));
        cameraSystem.setBounds(100, 100, 100, 50);
        cameraSystem.addActionListener(e -> openCamera());
        
        // this.terminal = new JButton("Terminal");
        // terminal.setActionCommand("Terminal");
        // terminal.setPreferredSize(new Dimension(100, 50));
        // terminal.setBounds(100, 200, 100, 50);
        // terminal.addActionListener(e -> openTerminal());

        this.exitButton = new JButton("Exit");
        exitButton.setActionCommand("Exit");
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBounds(100, 300, 100, 50);
        exitButton.addActionListener(e -> exitComputer());
        // this.label = new JLabel("Computer Scene");
        // //TODO: Create a display label for camera and terminal
        // //TODO: Add exit button
        
        computerPanel.add(cameraSystem);
        // computerPanel.add(terminal);
        computerPanel.add(exitButton);

    }
    
    public JPanel getPanel() {
        return computerPanel;
    }

    public void openCamera() {
        client.setScene(new CameraSystemScene(client, leftRobot, rightRobot, centerRobot, gameScene));
    }

    // public void openTerminal() {
    //     // client.setScene(new TerminalScene());

    // }

    public void exitComputer() {
        GameState.setCameraOn(false);
        client.setScene(gameScene);
    }

}
