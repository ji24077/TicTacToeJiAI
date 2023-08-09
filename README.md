# TicTacToe Game README

## Summary

The TicTacToe Game is a simple two-player game implemented in Java using Android Studio. The game allows two players to take turns marking cells on a 3x3 grid with their respective symbols (X or O). The player who successfully marks three cells in a row, column, or diagonal wins the game. If all cells are marked and no player wins, the game ends in a draw.

## Use Cases

1. Players can start a new game.
2. Players can make moves by clicking on empty cells.
3. The game checks for a win or draw after each move.
4. Players can reset the game to play again.

## User Story

As a player, I want to enjoy a game of TicTacToe against a friend, where we take turns marking cells and the game notifies us of the outcome.

## Design Patterns

1. Model-View-Presenter (MVP) Architecture: Separates the logic into three components - Model (TicTacToeModel), View (MainActivity), and Presenter (TicTacToePresenter), improving maintainability and testability.
2. Observer Pattern: Used to notify the MainActivity of game state changes (player turn, win, draw) from the TicTacToeModel.

## Java Version and Testing Framework

The program is implemented using Java. For unit testing, JUnit framework was used.

## Code Smells and SOLID/CA Violations

No code smells or violations of SOLID or Common Architectural (CA) principles were identified in the provided conversation log and code snippets.

## Remaining Improvements

1. Implement AI opponent for single-player mode.
2. Add animations for a better user experience.
3. Enhance UI with better styling and user feedback.

**Note:** This summary is based on the information and code provided in the conversation log. If there are any additional details or code snippets not mentioned in the log, they might affect the accuracy of this summary.
