package com.finalproject.scenes;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class WinScene implements Scene {
    private JPanel winPanel;
    private JLabel label;

    public WinScene() {
        this.winPanel = new GamePanel();
        this.label = new JLabel("You Win!");

        label.setFont(new Font("Arial", Font.BOLD, 200));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        winPanel.setLayout(new GridBagLayout());
        winPanel.add(label);
    }

    public JPanel getPanel() {
        return winPanel;
    }
}
