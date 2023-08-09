package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GameObserver {

    private final Button[][] buttons = new Button[3][3];
    private TextView textViewPlayer;
    private TicTacToePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer = findViewById(R.id.text_view_player);
// Initialize model and presenter
        // Initialize model and presenter
        TicTacToeModel model = new TicTacToeModel();
        model.addObserver(this); // Register MainActivity as an observer
        presenter = new TicTacToePresenter(model, this);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int column = j;
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        char type = model.isPlayerXTurn() ? 'O' : 'X';
                        model.updateCell(row, column, type);
                        presenter.onButtonClicked((Button) v);

                    }
                });
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetButtonClicked();
            }
        });

        // Set initial player status
        updatePlayerStatus(true);
    }
    @Override
    public void onGameStateChanged(boolean isPlayerXTurn, boolean isGameWon, boolean isDraw) {
        updatePlayerStatus(isPlayerXTurn);

        if (isGameWon) {
            String currentPlayer = isPlayerXTurn ? "X" : "O";
            showPlayerWins(currentPlayer);
        } else if (isDraw) {
            showDraw();
        }
    }

    // Update player status text view
    @SuppressLint("SetTextI18n")
    public void updatePlayerStatus(boolean isPlayerXTurn) {
        if (isPlayerXTurn) {
            textViewPlayer.setText("Player X's turn");
        } else {
            textViewPlayer.setText("Player O's turn");
        }
    }



    // Show winning player
    @SuppressLint("SetTextI18n")
    public void showPlayerWins(String player) {
        textViewPlayer.setText(player + " wins!");
        System.out.println("Player " + player + " wins!"); // Add this line
        disableButtons();
    }

    // Show draw
    @SuppressLint("SetTextI18n")
    public void showDraw() {
        textViewPlayer.setText("It's a draw!");
        disableButtons();
    }

    // Reset game UI
    public void resetGameUI() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        updatePlayerStatus(true);
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
