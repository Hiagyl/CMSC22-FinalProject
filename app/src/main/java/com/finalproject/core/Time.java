package com.finalproject.core;

import javax.swing.JLabel;

import com.finalproject.app.GameClient;
import com.finalproject.scenes.SurvivedScene;

public class Time implements Runnable{
    private int time;
    private JLabel label;
    private GameClient client;

    public Time(JLabel label, GameClient client) {
        this.time = 0;
        this.label = label;
        this.label.setText("12:00 AM");
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (time < 50) {
                    label.setText("12:00 AM");
                } else if (time >= 50 && time < 300){
                    label.setText(time/50 + ":00 AM");
                } else {
                    client.setScene(new SurvivedScene());
                }

                Thread.sleep(1000);
                time++;
                System.out.println(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
