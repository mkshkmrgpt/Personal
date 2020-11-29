package com.example;

import com.example.util.NormalDice;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void shouldCreateBoardOfSize100() {
        Board board = new Board(100);
        assertEquals(100, board.size());
    }

    @Test
    public void shouldRegisterPlayersAndDice() {
        Board board = new Board(100);
        board.registerPlayer(new Player(1));
        assertEquals(1, board.players().size());
    }

    @Test
    public void shouldUpdatePlayerPositionWhenDiceIsRolled(){
        Board board = new Board(100);
        board.registerPlayer(new Player(1));
        int number = new NormalDice().roll();
        board.updatePlayer(1, number);
        Player player = board.players().stream().filter(player1 -> player1.getId() == 1).findFirst().orElseGet(() -> new Player(0));
        assertEquals(number, player.getCurrentPosition());
    }

    @Test
    public void shouldReturnWinnerPlayerWhenPlayerPositionEqualsBoardSize(){
        Board board = new Board(100);
        board.registerPlayer(new Player(2));
        board.updatePlayer(2, 100);
        Optional<Player> winner = board.winner();
        assertTrue(winner.isPresent());
        assertEquals(2, winner.get().getId());
        board.status();
    }

    @Test
    public void shouldUpdatePlayerPositionToSnakeEndPositionWhenPlayerReachesSnakeStartPosition(){
        Board board = new Board(100);
        board.registerPlayer(new Player(1));
        board.registerSnake(new Snake(10, 5));

        board.updatePlayer(1, 10);
        Player player = board.players().stream().filter(player1 -> player1.getId() == 1).findFirst().orElseGet(() -> new Player(0));
        assertEquals(5, player.getCurrentPosition());
        board.status();
    }
}
