package com.finalproject.scenes;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.finalproject.core.GamePanel;

public class NightScene implements Scene {
    private JPanel nightPanel;
    private JLabel label;

    public NightScene(int night) {
        this.nightPanel = new GamePanel();
        this.label = new JLabel("Night " + night);

        label.setFont(new Font("Arial", Font.BOLD, 200));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nightPanel.setLayout(new GridBagLayout());
        nightPanel.add(label);
    }
    
    public JPanel getPanel() {
        return nightPanel;
    }
}
