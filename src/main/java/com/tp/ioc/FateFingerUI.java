package com.tp.ioc;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class FateFingerUI extends JFrame {
    private JButton startButton;
    private JTextArea textArea;
    private Random random = new Random();
    private List<Player> players = new ArrayList<>();
    private Set<Integer> usedNumbers = new HashSet<>();

    public FateFingerUI() {
        this.setTitle("FateFinger");
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the entire prgm when u click on X
        this.setLayout(new BorderLayout()); // ✅ very important

        //create textArea and button
        textArea = new JTextArea();
        textArea.setEditable(false); // it s readOnly
        JScrollPane scrollPane = new JScrollPane(textArea); //Putting thetext in a scrollable

        this.startButton = new JButton("Start Game");
        startButton.addActionListener(e -> startGame());

        //adding textarea and button
        this.add(startButton, BorderLayout.CENTER);
        this.add(scrollPane,BorderLayout.SOUTH);

    }

    public void startGame() {
        //emptying the previous
        players.clear();
        usedNumbers.clear();
        textArea.setText("");

        //getting user inputs
        int min= readInt("enter the minimum range");
        int max= readInt("enter the maximum range");
        int playersNumber = readInt("enter the number of players");

        if(min >= max || (max - min+1)<playersNumber){
            System.out.println("Enter a valid range!");
            return;
        }

        for(int i=0;i<playersNumber;i++){
            players.add(new Player(i+1));
        }

        for(Player p: players){
            JOptionPane.showMessageDialog(this,"Player "+ p.getNumber() +" is playing, Press OK to roll the dice...");

            p.rollDice(usedNumbers,random,min,max);

            JOptionPane.showMessageDialog(this,"Player "+ p.getNumber() +" rolled : "+ p.getDice());
        }

        Player loser = Collections.min(players,Comparator.comparingInt(p->p.getDice()));
        JOptionPane.showMessageDialog(this,"Player "  + loser.getNumber() + " loses with " + loser.getDice() + "!");
    }

    public int readInt(String message){
        while(true){
            String input = JOptionPane.showInputDialog(message);
            try{
                return Integer.parseInt(input);
            } catch( Exception e){
                JOptionPane.showMessageDialog(this,"Please enter a valid number");
            }
        }
    }


}
