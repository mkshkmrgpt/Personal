package com.example.util;

import java.util.Random;

public class EvenDice implements Dice {

    @Override
    public int roll() {
        Random random = new Random();
        int num = 3;
        while (num%2!=0) {
            num = random.ints(1, 7)
                    .findAny().getAsInt();
        }
        return num;
    }
}
