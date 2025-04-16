package com.tp.ioc;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        String[] options= {"Console Mode", "UI Mode"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose how you want to play",
                "FateFinger",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
                );

        if(choice == 0){
            new FateFinger().start();
            System.exit(0);
        } else if (choice == 1 ){
            //new FateFingerUI().startGame();
            SwingUtilities.invokeLater(() -> {
                FateFingerUI ui = new FateFingerUI();
                ui.setVisible(true); // shows the window
            });
        } else{
            System.out.println("No mode selected. Exiting...");
            System.exit(0);
        }

    }
}
