package com.finalproject.models;

import java.util.ArrayList;

import com.finalproject.app.GameClient;

public abstract class Robot {
    private ArrayList<String> path;
    private int currentPath;
    private int level;
    private GameClient client;

    public Robot(ArrayList<String> path, int level) {
        this.path = path;
        this.currentPath = 0;
        this.level = level;
    }

    public Robot(int level) {
        this(null, level);
    }

    public void setClient(GameClient client) {
        this.client = client;
    }
    
    public GameClient getClient() {
        return client;
    }
    
    public String getPath(int n){
        return path.get(n); 
    }
    
    public int getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(int currentPath) {
        this.currentPath = currentPath;
    }

    public int getLevel() {
        return level;
    }
    
    public abstract void startThread();

    public abstract void attack();

    public abstract void stop();
    
}
