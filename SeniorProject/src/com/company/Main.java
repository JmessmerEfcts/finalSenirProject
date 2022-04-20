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
         @Work on Battle Sequence
         @boss attacks dont damage you
         @sometimes boss doesnt select a weapon
         @
         */

        System.out.println("okay " + userClassChoice + " you have entered room 1");

        Boss bossObj = new Boss();
            bossObj.generateBossWeapon();
            bossObj.setBossName();
            System.out.println(bossObj.toString());

        Battle battle = new Battle(player, bossObj);

        //displays possible player actions
        battle.playerActionChoices();
         String playerAction = sc.nextLine();
         System.out.println(playerAction);

        //Boss chooses action
        battle.possibleBossActions();

        //calculate results
        //battle.checkMoves();
        //playerMoves(player,bossObj);

       //display player stats
       System.out.println(player);


          /*
        TODO
         @Work on Battle Sequence
         @boss attacks dont damage you
         @sometimes boss doesnt select a weapon
         @
         */
    }


//    public static void playerMoves(Player player, Boss boss){
//        Scanner sc = new Scanner(System.in);
//        //display playerActionChoice()
//        player.playerActionChoices();
//        String userAction = sc.nextLine();
//        player.setPlayerAction(userAction);
//        System.out.println(userAction);
//
//        //display bosses move
//        boss.possibleBossActions();
//        player.decreasePlayerHpByOne();
//    }

}


