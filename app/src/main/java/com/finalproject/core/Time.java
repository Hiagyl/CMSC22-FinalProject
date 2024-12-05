package com.finalproject.core;

import javax.swing.Timer;

import javax.swing.JLabel;

import com.finalproject.app.GameClient;
import com.finalproject.scenes.GameScene;
import com.finalproject.scenes.MainMenuScene;
import com.finalproject.scenes.WinScene;

public class Time implements Runnable{
    private int time;
    private JLabel label;
    private GameClient client;
    // private MainMenuScene menu;
    private boolean running;
    private GameScene gameScene;

    public Time(JLabel label, GameClient client, MainMenuScene menu, GameScene gameScene) {
        this.time = 0;
        this.label = label;
        this.label.setText("12:00 AM");
        this.client = client;
        // this.menu = menu;
        this.running = true;
        this.gameScene = gameScene;
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
                if (time < 50) {
                    label.setText("12:00 AM");
                } else if (time >= 50 && time < 300) {
                    label.setText(time / 50 + ":00 AM");
                } else {
                    System.out.println("You survived the night!");

                    client.setScene(new WinScene());
                    Timer timer = new Timer(3000, e -> System.exit(0));
                    timer.setRepeats(false);
                    timer.start();
                }

                Thread.sleep(1000);
                time++;
                System.out.println(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stopAllThreads() {
        gameScene.stopAllThreads();
    }
}
