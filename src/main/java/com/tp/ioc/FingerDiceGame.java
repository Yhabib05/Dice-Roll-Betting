package com.tp.ioc;

import java.util.*;

public class FingerDiceGame {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<Player> players = new ArrayList<>();
    Set<Integer> usedNumbers = new HashSet<>();

    public void start(){
        int min= readInt("enter the minimum range");
        int max= readInt("enter the maximum range");
        int playersNumber = readInt("enter the number of players");
        this.sc.nextLine();


        if(min >= max || (max - min+1)<playersNumber){
            System.out.println("Enter a valid range!");
            return;
        }


        for(int i=0;i<playersNumber;i++){
            players.add(new Player(i));
        }

        for(Player p: players){
            System.out.println("Player "+ p.number +" is playing, Press a Key to roll the dice...");
            this.sc.nextLine();
            p.rollDice(usedNumbers,random,min,max);
            System.out.println("Player "+ p.number +" rolled dice! \n He got : "+ p.dice);

        }

        Player loser = Collections.min(players,Comparator.comparingInt(p->p.dice));
        System.out.println("Player "  + loser.number + " loses with " + loser.dice);

    }

    private int readInt(String message){
        System.out.println(message);
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Please enter an integer");
        }
        return sc.nextInt();
    }

}
