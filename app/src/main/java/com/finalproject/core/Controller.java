package com.finalproject.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.finalproject.app.GameClient;
import com.finalproject.scenes.ComputerScene;

public class Controller implements ActionListener {
    private GameClient client;

    public void setGameClient(GameClient client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Computer":
                //TODO: Add functionalities for ComputerScene
                client.setScene(new ComputerScene());
                break;
            case "Right Door":
                System.out.println("Right Door");
                break;
            case "Left Door":
                System.out.println("Left Door");
                break;
            case "Right Light":
                System.out.println("Right Light");
                break;
            case "Left Light":
                System.out.println("Left Light");
                break;
            case "Antivirus":
                // client.setScene(new AntivirusScene());
                break;
            default:
                break;
        }
    }

}
