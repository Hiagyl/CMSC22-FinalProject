package com.finalproject.scenes;

import java.awt.BorderLayout;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.app.GameClient;
import com.finalproject.core.GamePanel;

public class MainMenuScene implements Scene{
    private GameClient client;
    private JPanel menuPanel;
    private JPanel westPanel;
    private JPanel buttonsPanel;
    private JLabel title;
    private JButton startButton;
    private JButton continueButton;
    private JButton exitButton;

    public MainMenuScene(GameClient client) {
        this.client = client;
        menuPanel = new GamePanel(new BorderLayout(), true);
        westPanel = new GamePanel(new BorderLayout(), true);
        buttonsPanel = new GamePanel();

        title = new JLabel("FNAF");

        startButton = new JButton("Start");
        // startButton.setActionCommand("Start");
        startButton.addActionListener(e -> startGame());

        continueButton = new JButton("Continue");
        // continueButton.setActionCommand("Continue");
        continueButton.addActionListener(e -> continueGame());

        exitButton = new JButton("Exit");
        exitButton.setActionCommand("Exit");
        exitButton.addActionListener(e -> exitGame());

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
        client.setScene(new NightScene(1));
        
        Timer timer = new Timer(3000, e -> exitGame());
        
        client.setScene(new GameScene());


        
    }
    
    private void continueGame(){}

    private void exitGame() {
        System.exit(0);
    }

    @Override
    public JPanel getPanel() {
        return menuPanel;
    }

}
