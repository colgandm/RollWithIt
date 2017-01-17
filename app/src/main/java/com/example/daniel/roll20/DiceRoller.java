package com.example.daniel.roll20;

public class DiceRoller {


    public int roll(int numberOfSides) {
        int value = randomWithRange(numberOfSides);
        System.out.println("Rolled a d" + numberOfSides + " and got " + value);
        return value;
    }

//    public void roll(int numberOfSides) {
//        System.out.println("Rolled a d" + numberOfSides + " and got " + randomWithRange(numberOfSides));
//    }

    public int[] roll(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
            System.out.println("Rolled a d" + numberOfSides + " and got " + randomWithRange(numberOfSides));
        }
        return resultArray;
    }

//    public void roll(int numberOfDice, int numberOfSides) {
//        for (int i = 0; i < numberOfDice; i++) {
//            System.out.println("Rolled a d" + numberOfSides + " and got " + randomWithRange(numberOfSides));
//        }
//    }

    public void roll(int numberOfTimes, int numberOfDice, int numberOfSides) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println("Round " + (i + 1) + "\n");
            for (int j = 0; j < numberOfDice; j++) {
                System.out.println("Rolled a d" + numberOfSides + " and got " + randomWithRange(numberOfSides));
            }
        }
    }

    int randomWithRange(int max) {
        int range = ((max - 1) + 1);
        return (int) (Math.random() * range) + 1;
    }
}

