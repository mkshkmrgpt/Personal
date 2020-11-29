package com.example.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvenDiceTest {

    @Test
    public void shouldGenerateOnlyEvenNumbers(){

        EvenDice evenDice = new EvenDice();
        for (int i = 0; i < 5; i++) {
            int roll = evenDice.roll();
            System.out.println(roll);
            assertTrue(roll%2==0);
            assertTrue(roll<=6 && roll>0);
        }
    }
}