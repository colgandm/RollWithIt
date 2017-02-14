package com.example.daniel.rollwithit.utils;

import java.util.Arrays;

public class DiceRoller {

    public int[] roll(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
        }
        return resultArray;
    }

    public int[] roll(int numberOfDice, int numberOfSides, int modifier) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides) + modifier;
        }
        return resultArray;
    }

    public int rollSumWithModifier(int numberOfDice, int numberOfSides, int modifier) {
        int result = 0;
        for (int i = 0; i < numberOfDice; i++) {
            result += randomWithRange(numberOfSides) + modifier;
        }
        return result;
    }

    public int roll4d6DropLowest() {
        int[] resultArray = new int[4];
        int sum = 0;
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = randomWithRange(6);
        }
        Arrays.sort(resultArray);
        for (int j = 1; j < resultArray.length; j++) {
            sum += resultArray[j];
        }
        return sum;
    }

    private int randomWithRange(int max) {
        int range = ((max - 1) + 1);
        return (int)(Math.random() * range) + 1;
    }

    public String allRolls(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
        }
        return prettyPrintAllRolls(resultArray);
    }

    public String totalOfRolls(int numberOfDice, int numberOfSides) {
        int[] resultArray = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            resultArray[i] = randomWithRange(numberOfSides);
        }
        return prettyPrintTotal(resultArray);
    }

    private String prettyPrintAllRolls(int[] results) {
        String resultString = "Results : ";
        for (int result : results) {
            resultString += result + " ";
        }
        return resultString;
    }

    private String prettyPrintTotal(int[] results) {
        int resultsTotal = 0;
        for (int result : results) {
            resultsTotal += result;
        }
        return "Total : " + String.valueOf(resultsTotal);
    }
}
