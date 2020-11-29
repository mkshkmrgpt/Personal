package com.example.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvenDiceTest {

    @Test
    public void shouldGenerateOnlyEvenNumbers(){

        Dice evenDice = DiceFactory.getDice(DiceType.EVEN);
        for (int i = 0; i < 5; i++) {
            int roll = evenDice.roll();
            assertTrue(roll%2==0);
            assertTrue(roll<=6 && roll>0);
        }
    }
}