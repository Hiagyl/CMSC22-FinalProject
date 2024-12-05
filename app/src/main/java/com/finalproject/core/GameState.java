package com.finalproject.core;

public class GameState {
    private boolean currentLevel;
    private boolean isRightDoorOpen;
    private boolean isLeftDoorOpen;
    private boolean isRightLightOn;
    private boolean isLeftLightOn;
    private boolean isGameOver;
    private boolean isNightSurvived;

    public GameState(boolean currentLevel) {
        this.currentLevel = currentLevel;
        this.isRightDoorOpen = false;
        this.isLeftDoorOpen = false;
        this.isRightLightOn = false;
        this.isLeftLightOn = false;
        this.isGameOver = false;
        this.isNightSurvived = false;
    }

    public void setRightDoorOpen(boolean isRightDoorOpen) {
        this.isRightDoorOpen = isRightDoorOpen;
    }

    public void setLeftDoorOpen(boolean isLeftDoorOpen) {
        this.isLeftDoorOpen = isLeftDoorOpen;
    }

    public void setRightLightOn(boolean isRightLightOn) {
        this.isRightLightOn = isRightLightOn;
    }

    public void setLeftLightOn(boolean isLeftLightOn) {
        this.isLeftLightOn = isLeftLightOn;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void setNightSurvived(boolean isNightSurvived) {
        this.isNightSurvived = isNightSurvived;
    }
}
