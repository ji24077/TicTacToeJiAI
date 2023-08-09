package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {

    private boolean playerXTurn = true;
    private int roundCount = 0;
    public final char[][] board = new char[3][3];

    public boolean isPlayerXTurn() {
        return playerXTurn;
    }

    public void switchPlayer() {
        playerXTurn = !playerXTurn;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void increaseRoundCount() {
        roundCount++;
    }

    public void markCell(int row, int col) {
        board[row][col] = playerXTurn ? 'X' : 'O';
    }

    public void updateCell(int row, int col, char type) {
        board[row][col] = type;
    }
    public boolean checkForDraw() {
        return roundCount == 9 && !checkForWin();
    }
    public boolean checkForWin() {
        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }

        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }

        // Check diagonals for a win
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }

        return board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0];
    }
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        boolean isGameWon = checkForWin();
        boolean isDraw = roundCount == 9 && !isGameWon;
        for (GameObserver observer : observers) {
            observer.onGameStateChanged(playerXTurn, isGameWon, isDraw);
        }
    }

}
