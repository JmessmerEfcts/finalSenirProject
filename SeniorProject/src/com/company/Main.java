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
        System.out.println("Please enter your UserName");
        String userName = sc.nextLine();
        player.setUserName(userName);
        writer.write("UserName: " + userName + " ");

        System.out.println("Please enter your age");
        String userAge = sc.nextLine();
        player.setUserAge(userAge);
        writer.write("Age: " + userAge);
        writer.flush();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        //greet player with class choices
        System.out.println("Welcome to Dungeony Dungeon " +userName+ " who would you like to play as?");
        System.out.println(" ");
        player.displayClassChoices();
        //global variables for userInfo
        String userClassChoice = sc.nextLine();
        System.out.println(" ");
        //conditionals Calculating userClassChoice  & writing user's choice
        //to an external file
        boolean condition = false;
        do{
            if(userClassChoice.equals("soldier") || userClassChoice.equals("Soldier")){
                condition = true;
                player.setSoldier();
                player.getPlayerClassChoice();
                System.out.println(player.toString());
            }else if(userClassChoice.equals("tank") || userClassChoice.equals("Tank")){
                condition = true;
                writer.write(userClassChoice);
                player.setTank();
                System.out.println(player);
            }else if(userClassChoice.equals("archer") || userClassChoice.equals("Archer")){
                condition = true;
                writer.write(userClassChoice);
                player.setArcher();
                System.out.println(player);
            }else if(userClassChoice.equals("wizard") || userClassChoice.equals("Wizard")){
                condition = true;
                writer.write(userClassChoice);
                player.setWizard();
                System.out.println(player);
            }else {
                condition = false;
                System.out.println("Nope try again champ");
                userClassChoice = sc.nextLine();
            }
        }while(condition == false);
        //you must flush the BufferedWriter obj in order to write text
        writer.flush();

        System.out.println("okay " + userClassChoice + " you have entered room 1");

        Boss bossObj = new Boss();
            bossObj.generateBossWeapon();
            bossObj.setBossName();
            System.out.println(bossObj.toString());

        Battle battle = new Battle(player, bossObj);
        int playerMax = player.getPlayerMax();
        int playerMin = player.getPlayerMin();
        int playerCurrentHp = player.getPlayerHp();

        int bossCurrentHealth = bossObj.getBossHp();
        int bossMax = bossObj.getBossMax();
        int bossMin = bossObj.getBossMin();

            System.out.println("playerHp " + player.getPlayerHp());
            System.out.println("BossHp " + bossObj.getBossHp());

         while(playerCurrentHp > playerMin || bossCurrentHealth > bossMin) {
              playerMax = player.getPlayerMax();
              playerMin = player.getPlayerMin();
              playerCurrentHp = player.getPlayerHp();

              bossCurrentHealth = bossObj.getBossHp();
              bossMax = bossObj.getBossMax();
              bossMin = bossObj.getBossMin();

           //displays possible player actions
           battle.playerActionChoices();
           System.out.println("TEST " + player.getPlayerAction());

           //Boss chooses action
           battle.possibleBossActions();

           battle.calculateResults();

           //display player stats
           System.out.println("HP: " + player.getPlayerHp());
           System.out.println("Class: " + player.getPlayerClassChoice());

           //display boss stats
           System.out.println("Boss Health " + bossObj.getBossHp());
           System.out.println("Boss weapon " + bossObj.getBossWeapon());

           if(bossCurrentHealth == bossMin){
               System.out.println("You have Defeated the Boss!!! You Win");
               break;
           }else if(playerCurrentHp == playerMin){
               System.out.println("You died Game Over");
               break;
           }
         } //end while

        System.out.println("Game Ended");

       }
   }

        //display player moves and ask again until player health is zero or boss health is zero




          /*
        TODO
         @if user uses light attack and boss uses dodge/block null pointer exception
         @bossAction is assigned after user action it doesnt know what it is yet
         @maybe getter??? or SETTTTEERRRR????????????????
         */



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



