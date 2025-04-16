package com.tp.ioc;

import java.util.Random;
import java.util.Set;

public class Player {
    private int number;
    private int dice;

    public int getDice() {
        return dice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public Player(int number) {
        this.number = number;
    }

    public void rollDice(Set<Integer> usedNumbers, Random random, int diceRangeMin, int diceRangeMax){
        int diceNumber;
        do {
            diceNumber = random.nextInt(diceRangeMax-diceRangeMin+1) + diceRangeMin;

        } while(usedNumbers.contains(diceNumber));
        usedNumbers.add(diceNumber);
        this.setDice(diceNumber);
    }

}
