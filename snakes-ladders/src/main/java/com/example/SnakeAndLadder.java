package com.example;

import com.example.util.DiceFactory;
import com.example.util.DiceType;

public class SnakeAndLadder {

    public static void main(String[] args) {
        play();
    }

    public static void play(){
        Board board = new Board(100);
        board.registerPlayer(new Player(1));
        board.registerSnake(new Snake(25, 5));
        board.registerSnake(new Snake(35, 15));
        board.registerSnake(new Snake(43, 23));

        for (int i = 0; i < 10; i++) {
            board.updatePlayer(1, DiceFactory.getDice(DiceType.NORMAL).roll());
            board.status();
        }
    }
}
