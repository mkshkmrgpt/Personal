package com.example.util;

import java.util.Random;

public class NormalDice implements DiceStrategy{
    public int roll() {
        Random random = new Random();
        return random.ints(1, 7)
                .findAny().getAsInt();
    }
}
