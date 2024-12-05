package com.finalproject.scenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.finalproject.app.GameClient;
import com.finalproject.core.GameController;
import com.finalproject.core.GamePanel;
import com.finalproject.core.GameState;
import com.finalproject.models.Robot;

public class MainMenuScene implements Scene{
    private GameClient client;
    private JFrame window;
    private JPanel menuPanel;
    // private JPanel westPanel;
    private JPanel buttonsPanel;
    private JLabel title;
    private JButton startButton;
    // private JButton continueButton;
    private JButton exitButton;
    private GameController controller;
    private Robot leftRobot;
    private Robot rightRobot;
    private Robot centerRobot;
    


    public MainMenuScene(GameClient client, JFrame window, ActionListener controller, Robot leftRobot, Robot rightRobot,
            Robot centerRobot) {
        this.client = client;
        this.window = window;
        this.controller = (GameController) controller;
        this.leftRobot = leftRobot;
        this.rightRobot = rightRobot;
        this.centerRobot = centerRobot;

        menuPanel = new GamePanel(new BorderLayout(), true);
        menuPanel.setBackground(Color.BLACK);
        // westPanel = new GamePanel(new BorderLayout(), true);
        buttonsPanel = new GamePanel();
        buttonsPanel.setBackground(Color.BLACK);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

        title = new JLabel("Night Shift");
        title.setFont(new Font("Arial", Font.BOLD, 76));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.LEFT);

        startButton = createButton("Start");
        startButton.addActionListener(e -> startGame());
        startButton.setFocusable(false);

        // continueButton = createButton("Continue");
        // continueButton.addActionListener(e -> continueGame());
        // continueButton.setFocusable(false);

        exitButton = createButton("Exit");
        exitButton.addActionListener(e -> exitGame());
        exitButton.setFocusable(false);

        buttonsPanel.add(startButton);
        buttonsPanel.add(Box.createVerticalStrut(20));
        // buttonsPanel.add(continueButton);
        // buttonsPanel.add(Box.createVerticalStrut(20));
        buttonsPanel.add(exitButton);

        menuPanel.add(title, BorderLayout.NORTH);
        menuPanel.add(buttonsPanel, BorderLayout.CENTER);

        // menuPanel.add(westPanel, BorderLayout.WEST);

        buttonsPanel.setVisible(true);
        // westPanel.setVisible(true);
        menuPanel.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setAlignmentX(JButton.LEFT_ALIGNMENT);
        return button;
    }

    private void startGame() {
        GameState.setCurrentLevel(1);
        client.setScene(new NightScene());

        // Thread 
        Timer timer = new Timer(3000, e -> client.setScene(new GameScene(client, window, controller, leftRobot, rightRobot, centerRobot, this)));
        timer.setRepeats(false);
        timer.start();
    }
    
    // private void continueGame() {
    
    //     //TODO: Add function that updates the night, ai level, etc
    // }

    private void exitGame() {
        System.exit(0);
    }

    @Override
    public JPanel getPanel() {
        return menuPanel;
    }

}
