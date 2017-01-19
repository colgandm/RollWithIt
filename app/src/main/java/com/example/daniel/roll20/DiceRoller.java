package com.example.daniel.roll20;

public class DiceRoller {

    public int[] roll(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
            System.out.println("Rolled a d" + numberOfSides + " and got " + randomWithRange(numberOfSides));
        }
        return resultArray;
    }

    int randomWithRange(int max) {
        int range = ((max - 1) + 1);
        return (int)(Math.random() * range) + 1;
    }
}
