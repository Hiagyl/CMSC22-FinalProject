package com.finalproject.core;

public class GameState {
    private static int currentLevel;
    private static boolean isRightDoorOpen;
    private static boolean isLeftDoorOpen;
    private static boolean isRightLightOn;
    private static boolean isLeftLightOn;
    private static boolean isControlShocked;
    private static boolean isGameOver;
    private static boolean isNightSurvived;

    // Private constructor to prevent instantiation
    private GameState(int currentLevel) {
        GameState.currentLevel = currentLevel;
        GameState.isRightDoorOpen = false;
        GameState.isLeftDoorOpen = false;
        GameState.isRightLightOn = false;
        GameState.isLeftLightOn = false;
        GameState.isControlShocked = false;
        GameState.isGameOver = false;
        GameState.isNightSurvived = false;
    }

    public static boolean isRightDoorOpen() {
        return isRightDoorOpen;
    }

    public static void setRightDoorOpen(boolean isRightDoorOpen) {
        GameState.isRightDoorOpen = isRightDoorOpen;
    }

    public static boolean isLeftDoorOpen() {
        return isLeftDoorOpen;
    }

    public static void setLeftDoorOpen(boolean isLeftDoorOpen) {
        GameState.isLeftDoorOpen = isLeftDoorOpen;
    }

    public static boolean isRightLightOn() {
        return isRightLightOn;
    }

    public static void setRightLightOn(boolean isRightLightOn) {
        GameState.isRightLightOn = isRightLightOn;
    }

    public static boolean isControlShocked() {
        return isControlShocked;
    }

    public static void setControlShocked(boolean isControlShocked) {
        GameState.isControlShocked = isControlShocked;
    }

    public static boolean isLeftLightOn() {
        return isLeftLightOn;
    }

    public static void setLeftLightOn(boolean isLeftLightOn) {
        GameState.isLeftLightOn = isLeftLightOn;
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

    public static void reset() {
        GameState.isRightDoorOpen = false;
        GameState.isLeftDoorOpen = false;
        GameState.isRightLightOn = false;
        GameState.isLeftLightOn = false;
        GameState.isControlShocked = false;
        GameState.isGameOver = false;
        GameState.isNightSurvived = false;
    }
}