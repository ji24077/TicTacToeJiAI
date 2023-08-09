package com.example.myapplication;

public interface GameObserver {
    void onGameStateChanged(boolean isPlayerXTurn, boolean isGameWon, boolean isDraw);
}
