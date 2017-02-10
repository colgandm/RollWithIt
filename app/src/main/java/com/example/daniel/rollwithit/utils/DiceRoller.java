package com.example.daniel.rollwithit.utils;

public class DiceRoller {

    public int[] roll(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
        }
        return resultArray;
    }

    private int randomWithRange(int max) {
        int range = ((max - 1) + 1);
        return (int)(Math.random() * range) + 1;
    }
}
