package com.finalproject.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    public GamePanel() {
        this(new FlowLayout(), true);
    }

    public GamePanel(int width, int height) {
        this(new FlowLayout(), true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GRAY);
    }

    public GamePanel(LayoutManager layout, boolean isEnabled) {
        this.setLayout(layout);
        this.setBackground(Color.BLACK);
        this.setEnabled(isEnabled);
        this.setFocusable(false);
    }
}
