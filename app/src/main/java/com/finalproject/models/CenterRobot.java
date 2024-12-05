package com.finalproject.models;

import com.finalproject.core.GameState;

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
                try {
                    Thread.sleep(25000); // Wait for 25 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (angerLevel < 4) {
                    angerLevel++;
                    System.out.println("Anger Level: " + angerLevel);
                }

                if (angerLevel == 4) {
                    attack();
                }
            }
        }).start();
    }

    @Override
    public void attack() {
        try {
            // Wait for 10 seconds before attacking
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the controlled shock is activated
        if (!GameState.isControlShocked()) {
            // Set the game state to game over
            GameState.setGameOver(true);
            System.out.println("Game Over: Controlled shock was not activated.");
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
