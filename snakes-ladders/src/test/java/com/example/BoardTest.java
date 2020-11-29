package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldCreateBoardOfSize100(){

        Board board = new Board();
        assertEquals(100, board.size());
    }

}