package com.example.myapplication;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToePresenter extends AppCompatActivity {

    private TicTacToeModel model;
    private final MainActivity view;

    public TicTacToePresenter(TicTacToeModel model, MainActivity view) {
        this.model = model;
        this.view = view;
    }

    public void onButtonClicked(Button button) {
        if (!button.getText().toString().equals("")) {
            return;
        }

        if (model.isPlayerXTurn()) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        model.increaseRoundCount();

        if (model.checkForWin()) {
            String currentPlayer = model.isPlayerXTurn() ? "X" : "O"; // Switched 'X' and 'O'
            view.showPlayerWins(currentPlayer);

        }else  if (model.getRoundCount() == 9) {
            view.showDraw();
        }
        else{
            model.switchPlayer();
            view.updatePlayerStatus(model.isPlayerXTurn());
        }
    }


    public void onResetButtonClicked() {
        model = new TicTacToeModel(); // Reset the model
        view.resetGameUI();
    }
}
