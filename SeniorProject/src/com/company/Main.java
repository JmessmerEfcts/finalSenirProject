package com.company;

import com.company.Player;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("userInfo"));

        //creates empty player obj
        Player player = new Player();

        //ask for userInfo and store in external file
        System.out.println("Please enter your name");
        String userName = sc.nextLine();
        player.setUserName(userName);
        writer.write("Name: " + userName + " ");

        System.out.println("Please enter your age");
        String userAge = sc.nextLine();
        player.setUserAge(userAge);
        writer.write("Age: " + userAge);

        writer.flush();

        //greet player with class choices
        System.out.println("Welcome to Dungeony Dungeon " +userName+ " who would you like to play as?");
        player.displayClassChoices();
        //global variables for userInfo
        String userClassChoice = sc.nextLine();

        if(userClassChoice.equals("soldier")){
            player.setSoldier();
            System.out.println(player.toString());
        }else if(userClassChoice.equals("tank")){
            writer.write(userClassChoice);
            player.setTank();
            System.out.println(player);
        }else if(userClassChoice.equals("archer")){
            writer.write(userClassChoice);
            player.setArcher();
            System.out.println(player);
        }else if(userClassChoice.equals("wizard")){
            writer.write(userClassChoice);
            player.setWizard();
            System.out.println(player);
        }else {
            System.out.println("Nope");
        }
        writer.flush();

        /*
        TODO
         @setup story and game progress walking in the dungeon selecting doors etc
         @ updating boss class and player fighting
         @ maybe setup a class that contains all the possible actions the user can make
         @ update external file to make sure thats working properly
         */


    }

}


