package com.finalproject.models;

import java.util.ArrayList;

public abstract class Robot {
    private ArrayList<String> path;
    private int currentPath;
    private int level;

    public Robot(ArrayList<String> path, int level) {
        this.path = path;
        this.currentPath = 0;
        this.level = level;
    }

    public Robot(int level) {
        this(null, level);
    }
    
    public String getPath(){
        return path.toString(); 
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
    
}
