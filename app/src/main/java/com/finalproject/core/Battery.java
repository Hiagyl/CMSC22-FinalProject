package com.finalproject.core;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Battery implements Runnable {
    private static Battery instance;
    private double batteryLevel;
    private boolean running;
    private JLabel label;

    // Private constructor to prevent instantiation
    private Battery(JLabel label) {
        this.label = label;
        this.batteryLevel = 100.0; // Initialize battery level to 100%
        this.running = true;
    }

    // Public method to provide access to the single instance
    public static Battery getInstance(JLabel label) {
        if (instance == null) {
            instance = new Battery(label);
        }
        return instance;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            if (GameState.isGameOver() || GameState.isNightSurvived()) {
                stop();
                break;
            }
            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate depletion rate based on GameState
            double depletionRate = 0.1; // Base depletion rate

            if (!GameState.isRightDoorOpen()) {
                depletionRate += 0.5;
            }
            if (!GameState.isLeftDoorOpen()) {
                depletionRate += 0.5;
            }
            if (GameState.isRightLightOn()) {
                depletionRate += 0.3;
            }
            if (GameState.isLeftLightOn()) {
                depletionRate += 0.3;
            }
            if (GameState.isControlShocked()) {
                depletionRate += 0.2;
            }
            if(GameState.isCameraOn()){
                depletionRate += 0.7;
            }

            // Deplete battery
            batteryLevel -= depletionRate;
            label.setText(Math.max((int) batteryLevel, 0) + "%");
            // Ensure battery level does not go below 0
            if (batteryLevel < 0) {
                batteryLevel = 0;
                running = false; // Stop the thread if the battery is depleted
                GameState.setGameOver(true); // Set game over state
                System.out.println("Game Over: Battery depleted.");
                Timer timer = new Timer(3000, e -> System.exit(0));
                timer.start(); 
            }

            System.out.println("Battery Level: " + batteryLevel + "%");
        }
    }
}