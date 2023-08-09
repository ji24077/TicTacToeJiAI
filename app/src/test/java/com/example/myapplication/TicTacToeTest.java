package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToeModel model;

    @Before
    public void setUp() {
        model = new TicTacToeModel();
    }

    @Test
    public void testInitialGameState() {
        assertTrue(model.isPlayerXTurn());
        assertEquals(0, model.getRoundCount());
    }

    @Test
    public void testPlayerSwitch() {
        model.switchPlayer();
        assertFalse(model.isPlayerXTurn());
    }

    @Test
    public void testIncreaseRoundCount() {
        model.increaseRoundCount();
        assertEquals(1, model.getRoundCount());
    }

    @Test
    public void testMarkCell() {
        model.markCell(1, 1);
        assertTrue(model.isPlayerXTurn());
    }

    @Test
    public void testCheckForWin() {
        model.updateCell(0, 0, 'X');
        model.updateCell(0, 1, 'X');
        model.updateCell(0, 2, 'X');
        assertTrue(model.checkForWin());
    }

    @Test
    public void testDraw() {
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.increaseRoundCount();
        model.updateCell(0, 0, 'X');
        model.updateCell(0, 1, 'O');
        model.updateCell(0, 2, 'X');
        model.updateCell(1, 0, 'X');
        model.updateCell(1, 1, 'X');
        model.updateCell(1, 2, 'O');
        model.updateCell(2, 0, 'O');
        model.updateCell(2, 1, 'X');
        model.updateCell(2, 2, 'O');
        System.out.println(model.checkForDraw());
        assertTrue(model.checkForDraw());
    }
}
