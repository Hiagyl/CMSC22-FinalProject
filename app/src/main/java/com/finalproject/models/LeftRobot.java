package com.finalproject.models;

import com.finalproject.core.GameState;
import java.util.ArrayList;
import java.util.Random;

public class LeftRobot extends Robot implements Movable {
    private boolean running;

    public LeftRobot(ArrayList<String> path, int level) {
        super(path, level);
        this.running = true;
        // startThread();
    }

    @Override
    public void transferRoom() {
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1; // Generate a random number between 1 and 20

        if (randomNumber < this.getLevel()) {
            moveToNextPath();
        }
    }

    @Override
    public void moveToNextPath() {
        if (this.getCurrentPath() == 0) {
            this.setCurrentPath(1); // Move to path(1)
        } else if (this.getCurrentPath() == 1) {
            this.setCurrentPath(2); // Move to path(2)
            attack(); // Call attack method
        }
        System.out.println("Left robot moved to path " + getPath(this.getCurrentPath()));
    }

    public void attack() {
        try {
            // Pause for 6 seconds
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the left door is open
        if (GameState.isLeftDoorOpen()) {
            // Set the game state to game over
            GameState.setGameOver(true);
            System.out.println("Game Over: Left door was open during attack.");
        }
    }

    @Override
    public void startThread() {
        new Thread(() -> {
            while (running) {

                System.out.println("Left robot is transferring rooms...");
                try {
                    Thread.sleep(5000); // Wait for 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                transferRoom();
            }
        }).start();
    }

    public void stop() {
        running = false;
    }
}