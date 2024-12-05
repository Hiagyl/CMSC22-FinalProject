package com.finalproject.models;

import javax.swing.Timer;

// import com.finalproject.app.GameClient;
import com.finalproject.core.GameState;
import com.finalproject.scenes.GameOverScene;

public class CenterRobot extends Robot {
    private int angerLevel;
    private boolean running;

    public CenterRobot(int level) {
        super(level);
        this.angerLevel = 1; // Initialize anger level to 1
        this.running = true;
        // startThread();
    }

    @Override
    public void startThread() {
        new Thread(() -> {
            while (running) {
                System.out.println("Center robot is transferring rooms...");
                try {
                    Thread.sleep(2000); // Wait for 25 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (angerLevel < 4) {
                    angerLevel++;
                    System.out.println("Anger Level: " + angerLevel);
                }

                if (angerLevel == 4) {
                    System.out.println("Center robot is attacking...");
                    attack();
                }
            }
        }).start();
    }

    @Override
    public void attack() {
        try {
            // Wait for 10 seconds before attacking
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the controlled shock is activated
        if (!GameState.isControlShocked()) {
            // Set the game state to game over
            GameState.setGameOver(true);
            System.out.println("Game Over: Controlled shock was not activated.");
            getClient().setScene(new GameOverScene());
            Timer timer = new Timer(3000, e -> System.exit(0));
                    timer.start();
        } else {
            // Reset anger level to 1
            angerLevel = 1;
            System.out.println("Controlled shock activated. Anger level reset to 1.");
        }
    }

    public int getAngerLevel() {
        return angerLevel;
    }

    public void setAngerLevel(int angerLevel) {
        this.angerLevel = angerLevel;
    }

    public void stop() {
        running = false;
    }
}
