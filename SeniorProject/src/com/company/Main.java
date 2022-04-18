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

        //conditionals Calculating userClassChoice  & writing user's choice
        //to an external file
        if(userClassChoice.equals("soldier") || userClassChoice.equals("Soldier")){
            player.setSoldier();
            System.out.println(player.toString());
        }else if(userClassChoice.equals("tank") || userClassChoice.equals("Tank")){
            writer.write(userClassChoice);
            player.setTank();
            System.out.println(player);
        }else if(userClassChoice.equals("archer") || userClassChoice.equals("Archer")){
            writer.write(userClassChoice);
            player.setArcher();
            System.out.println(player);
        }else if(userClassChoice.equals("wizard") || userClassChoice.equals("Wizard")){
            writer.write(userClassChoice);
            player.setWizard();
            System.out.println(player);
        }else {
            System.out.println("Nope");
        }
        //you must flush the BufferedWriter obj in order to write text
        writer.flush();

        /*
        TODO
         @setup dungeon progression 5 rooms entering doors encountering bosses, picking up buffs
         @then put it together so that it flows nicely
         */

        System.out.println("okay " + userClassChoice + " you have entered room 1");
        Boss bossObj = new Boss();
            bossObj.setBossWeapon();
            bossObj.setBossName("Brog");
            System.out.println(bossObj.toString());

        System.out.println("What would you like to do?");
        //displays possible player actions
        player.playerActionChoices();
        String userAction = sc.nextLine();
        //sets the player action
        player.setPlayerAction(userAction);
        //displays possiblesBossActions
        bossObj.possibleBossActions();


        /*
        TODO
         @setup story and game progress walking in the dungeon selecting doors etc
         @using the playerActionChoices() function display the possible action choices
         @allow the user to select the choices and print it to the console
         @you have to use the Scanner but since the function is in another class that's challenging
         @I have a field in the player class called playerAction using the setPlayerAction function that might
         @all the user to select the choices
         */


    }

}


