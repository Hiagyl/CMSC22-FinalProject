package com.finalproject.core;

public class GameState {


    private static int currentLevel;
    private static boolean isRightDoorOpen = true;
    private static boolean isLeftDoorOpen = true;
    private static boolean isRightLightOn;
    private static boolean isLeftLightOn;
    private static boolean isControlShocked;
    private static boolean isGameOver;
    private static boolean isNightSurvived;
    private static boolean isCameraOn;


    // Private constructor to prevent instantiation
    // private GameState(int currentLevel) {
    //     GameState.currentLevel = currentLevel;
    //     GameState.isRightDoorOpen = true;
    //     GameState.isLeftDoorOpen = true;
    //     GameState.isRightLightOn = false;
    //     GameState.isLeftLightOn = false;
    //     GameState.isControlShocked = false;
    //     GameState.isGameOver = false;
    //     GameState.isNightSurvived = false;
    // }

    public static boolean isRightDoorOpen() {
        return isRightDoorOpen;
    }

    public static void setRightDoorOpen() {
        GameState.isRightDoorOpen = !GameState.isRightDoorOpen;
    }

    public static boolean isLeftDoorOpen() {
        return isLeftDoorOpen;
    }

    public static void setLeftDoorOpen() {
        GameState.isLeftDoorOpen = !GameState.isLeftDoorOpen;
    }

    public static boolean isRightLightOn() {
        return isRightLightOn;
    }

    public static void setRightLightOn() {
        GameState.isRightLightOn = !GameState.isRightLightOn;
    }

    public static boolean isLeftLightOn() {
        return isLeftLightOn;
    }

    public static void setLeftLightOn() {
        GameState.isLeftLightOn = !GameState.isLeftLightOn;
    }

    public static boolean isControlShocked() {
        return isControlShocked;
    }

    public static void setControlShocked() {
        GameState.isControlShocked = !GameState.isControlShocked;
    }

    public static boolean isGameOver() {
        return isGameOver;
    }

    public static void setGameOver(boolean isGameOver) {
        GameState.isGameOver = isGameOver;
    }

    public static boolean isNightSurvived() {
        return isNightSurvived;
    }

    public static void setNightSurvived(boolean isNightSurvived) {
        GameState.isNightSurvived = isNightSurvived;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        GameState.currentLevel = currentLevel;
    }

    public static boolean isCameraOn() {
        return isCameraOn;
    }

    public static void setCameraOn(boolean isCameraOn) {
        GameState.isCameraOn = isCameraOn;
    }

}