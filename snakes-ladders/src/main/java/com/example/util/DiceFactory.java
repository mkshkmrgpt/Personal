package com.example.util;

public class DiceFactory {

    private static Dice normalDice = new NormalDice();
    private static Dice evenDice = new EvenDice();

    public static Dice getDice(DiceType diceType){
        if(diceType.equals(DiceType.EVEN)){
            return evenDice;
        }
        return normalDice;
    }
}
