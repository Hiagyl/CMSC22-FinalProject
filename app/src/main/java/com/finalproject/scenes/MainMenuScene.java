package com.finalproject.scenes;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.finalproject.app.GameClient;
import com.finalproject.core.GameController;
import com.finalproject.core.GamePanel;
import com.finalproject.core.GameState;
import com.finalproject.models.Robot;

public class MainMenuScene implements Scene{
    private GameClient client;
    private JFrame window;
    private JPanel menuPanel;
    private JPanel westPanel;
    private JPanel buttonsPanel;
    private JLabel title;
    private JButton startButton;
    private JButton continueButton;
    private JButton exitButton;
    private GameController controller;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;
    


    public MainMenuScene(GameClient client, JFrame window, ActionListener controller, Robot leftRobot, Robot rightRobot, Robot centerRobot) {
        this.client = client;
        this.window = window;
        this.controller = (GameController) controller;
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;

        menuPanel = new GamePanel(new BorderLayout(), true);
        westPanel = new GamePanel(new BorderLayout(), true);
        buttonsPanel = new GamePanel();
        

        title = new JLabel("Nightshift");
        //TODO: ADD LOGO INSTEAD OF TEXT
        //TODO: DESIGN MAIN MENU

        startButton = new JButton("Start");
        startButton.addActionListener(e -> startGame());
        startButton.setFocusable(false);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> continueGame());
        continueButton.setFocusable(false);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> exitGame());
        exitButton.setFocusable(false);

        buttonsPanel.add(startButton);
        buttonsPanel.add(continueButton);
        buttonsPanel.add(exitButton);

        westPanel.add(title, BorderLayout.NORTH);
        westPanel.add(buttonsPanel, BorderLayout.CENTER);

        menuPanel.add(westPanel, BorderLayout.WEST);

        buttonsPanel.setVisible(true);
        westPanel.setVisible(true);
        menuPanel.setVisible(true);
    } 

    private void startGame() {
        GameState.setCurrentLevel(1);
        client.setScene(new NightScene(GameState.getCurrentLevel()));

        // Thread 
        Timer timer = new Timer(3000, e -> client.setScene(new GameScene(client, window, controller, leftRobot, rightRobot, centerRobot)));
        timer.setRepeats(false);
        timer.start();
    }
    
    private void continueGame() {
    
        //TODO: Add function that updates the night, ai level, etc
    }

    private void exitGame() {
        System.exit(0);
    }

    @Override
    public JPanel getPanel() {
        return menuPanel;
    }

}
