package com.example.util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NormalDiceTest {

    @Test
    public void shouldGenerateRandomNumbersBetween1To6() {
        for (int i = 0; i < 10; i++) {
            int play = new NormalDice().roll();
            assertTrue(play <=6 && play > 0);
        }
    }
}