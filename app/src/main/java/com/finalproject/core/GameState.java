package com.finalproject.core;

public class GameState {
    private static GameState instance;

    private int currentLevel;
    private boolean isRightDoorOpen;
    private boolean isLeftDoorOpen;
    private boolean isRightLightOn;
    private boolean isLeftLightOn;
    private boolean isGameOver;
    private boolean isNightSurvived;

    // Private constructor to prevent instantiation
    private GameState(int currentLevel) {
        this.currentLevel = currentLevel;
        this.isRightDoorOpen = false;
        this.isLeftDoorOpen = false;
        this.isRightLightOn = false;
        this.isLeftLightOn = false;
        this.isGameOver = false;
        this.isNightSurvived = false;
    }

    // Public method to provide access to the single instance
    public static GameState getInstance(int currentLevel) {
        if (instance == null) {
            instance = new GameState(currentLevel);
        }
        return instance;
    }

    public boolean isRightDoorOpen() {
        return isRightDoorOpen;
    }

    public void setRightDoorOpen(boolean isRightDoorOpen) {
        this.isRightDoorOpen = isRightDoorOpen;
    }

    public boolean isLeftDoorOpen() {
        return isLeftDoorOpen;
    }

    public void setLeftDoorOpen(boolean isLeftDoorOpen) {
        this.isLeftDoorOpen = isLeftDoorOpen;
    }

    public boolean isRightLightOn() {
        return isRightLightOn;
    }

    public void setRightLightOn(boolean isRightLightOn) {
        this.isRightLightOn = isRightLightOn;
    }

    public boolean isLeftLightOn() {
        return isLeftLightOn;
    }

    public void setLeftLightOn(boolean isLeftLightOn) {
        this.isLeftLightOn = isLeftLightOn;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public boolean isNightSurvived() {
        return isNightSurvived;
    }

    public void setNightSurvived(boolean isNightSurvived) {
        this.isNightSurvived = isNightSurvived;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}