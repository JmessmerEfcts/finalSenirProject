package com.company.gameEngine;


import javax.swing.*;
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

        battle(player, bossObj, writer);

        System.out.println("Game Ended");
    }




    public static void battle(Player bPlayer, Boss bBoss, BufferedWriter writer) {
        Player player = bPlayer;
        Boss bossObj = bBoss;

        Battle battle = new Battle(player, bossObj);
        int playerMax = player.getPlayerMax();
        int playerMin = player.getPlayerMin();
        int playerCurrentHp = player.getPlayerHp();

        int bossCurrentHealth = bossObj.getBossHp();
        int bossMax = bossObj.getBossMax();
        int bossMin = bossObj.getBossMin();

        System.out.println("playerHp " + player.getPlayerHp());
        System.out.println("BossHp " + bossObj.getBossHp());


        //player enters battle sequence
        do{
            playerMax = player.getPlayerMax();
            playerMin = player.getPlayerMin();
            playerCurrentHp = player.getPlayerHp();

            bossCurrentHealth = bossObj.getBossHp();
            bossMax = bossObj.getBossMax();
            bossMin = bossObj.getBossMin();

            try {
            if(bossCurrentHealth == bossMin){
                System.out.println("You have Defeated the Boss!!! You Win");
                writer.write(" boss defeated ");
                break;
            }else if(playerCurrentHp == playerMin){
                System.out.println("You died Game Over");
                writer.write(" you Died ");
                writer.flush();
                break;
            }
            } catch (IOException e) {
                System.out.println("ERROR " + e);
            }

            //display and set player action
            battle.playerActionChoices();

            //Boss sets an action
            battle.possibleBossActions();

            //check moves
            battle.calculateResults();

            //display health stats
            System.out.println("Boss Health " + bossObj.getBossHp());
            System.out.println("your Health: " + player.getPlayerHp());
            try {
            if(bossCurrentHealth == bossMin){
                System.out.println("You have Defeated the Boss!!! You Win");
                writer.write(" boss defeated ");
                break;
            }else if(playerCurrentHp == playerMin){
                System.out.println("You died Game Over");
                writer.write(" you Died ");
                writer.flush();
                break;
            }
            }catch (Exception e){
                System.out.println("ERROR " + e);
            }
        }while(playerCurrentHp >= playerMin || bossCurrentHealth >= bossMin);//end while
    }


}
