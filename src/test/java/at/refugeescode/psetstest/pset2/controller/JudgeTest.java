package at.refugeescode.psetstest.pset2.controller;

import at.refugeescode.psetstest.pset2.model.Result;
import at.refugeescode.psetstest.pset2.model.move.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {

    private Judge judge = new Judge();
    private Move move1;
    private Move move2;

    @BeforeEach
    public void cheatingBefore() {
        move1 = Mockito.mock(Move.class);
        move2 = Mockito.mock(Move.class);
    }

    //move1 win
    @Test
    public void move1DefeatMove2() {
        Mockito.when(move1.defeats(move2)).thenReturn(true);
        Result result = judge.getResult(move1, move2);
        // Assertions.assertEquals("player 1 wins", result.getWinner());
        assertAll(
                () -> {
                    assertEquals(move1, result.getMove1());
                    assertEquals(move2, result.getMove2());
                    assertEquals("Player 1 wins", result.getWinner());
                }
        );

    }

    @Test
    public void move2DefeatMove2() {
        Mockito.when(move2.defeats(move1)).thenReturn(true);
        Result result = judge.getResult(move1, move2);
        assertAll(
                () -> {
                    assertEquals(move1, result.getMove1());
                    assertEquals(move2, result.getMove2());
                    assertEquals("Player 2 wins", result.getWinner());
                }
        );

    }

    @Test
    public void noWinner() {
        Result result = judge.getResult(move1, move2);
        assertAll(
                () -> {
                    assertEquals(move1, result.getMove1());
                    assertEquals(move2, result.getMove2());
                    assertEquals("Nobody wins", result.getWinner());
                }
        );

    }

}