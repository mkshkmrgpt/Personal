package com.example;

public class Player {

    private int id;
    private int currentPosition;

    public Player(int id) {
        this.id = id;
        this.currentPosition = 0;
    }

    public int getId() {
        return id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
