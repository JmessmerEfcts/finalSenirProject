package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class Player {

    Soldier soldier = new Soldier();
    Tank tank = new Tank();
    Archer archer = new Archer();
    Wizard wizard = new Wizard();

    // array storing possible class selections for user
    Character characterArr[] = {soldier, tank, archer, wizard};

    private int playerMaxHp;
    private int playerMinHp;
    private int playerHp;
    private int playerHpUpdate;

    private String characterName;
    private String classChoice;
    private String playerWeaponType;
    private String playerAction;

    private String userName;
    private String userAge;


    public Player(){
        playerMaxHp = 0;
        playerMinHp = 0;
        playerHp = 0;
        characterName = "nameHere";
        classChoice = "no class";
        playerWeaponType = "no weapon";
        userName = " ";
        userAge = " ";
        playerAction = " ";
    }

    public  void displayClassChoices() {
        Scanner sc = new Scanner(System.in);

        String arr[] = {"Soldier", "Tank", "Archer", "Wizard"};
        int i;
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


    //getters
    public int getPlayerHp(){
        return playerHp;
    }

    public int getPlayerMax(){
        return playerMaxHp;
    }

    public int getPlayerMin(){
        return playerMinHp;
    }

    public String getPlayerName(){
        return characterName;
    }

    public String getPlayerClassChoice(){
        return classChoice;
    }

    public String getPlayerAction(){
        return playerAction;
    }

    public String getPlayerWeaponType(){
        return playerWeaponType;
    }

    //setters
    public void setUserName(String name){
        userName = name;
    }

    public void setUserAge(String age){
        userAge = age;
    }

    public void setPlayerAction(String action){
        playerAction = action;
    }

    public void setPlayerHp(int hp){
        playerHp = hp;
    }

    public void setSoldier(){
        classChoice = "Soldier";
        playerHp = soldier.getHitPoints();
        playerMaxHp = soldier.getSoldierMax();
        playerMinHp = soldier.getSoliderMin();
        characterName = soldier.getCharacterName();
        playerWeaponType = soldier.getWeaponType();
    }

    public void setTank(){
        classChoice = "Tank";
        playerHp = tank.getHitPoints();
        playerMaxHp = tank.getTankMax();
        playerMinHp = tank.getTankMin();
        characterName= tank.getCharacterName();
        playerWeaponType = tank.getWeaponType();

    }

    public void setArcher(){
        classChoice = "Archer";
        playerHp = archer.getHitPoints();
        playerMaxHp = archer.getArcherMax();
        playerMinHp = archer.getArcherMin();
        characterName= archer.getCharacterName();
        playerWeaponType = archer.getWeaponType();

    }

    public void setWizard(){
        classChoice = "Wizard";
        playerHp = wizard.getHitPoints();
        playerMaxHp = wizard.getWizardMax();
        playerMinHp = wizard.getWizardMin();
        characterName= wizard.getCharacterName();
        playerWeaponType = wizard.getWeaponType();
    }




    public String toString(){
        return "you are a " + classChoice + " with " + playerHp + "HP your Class is named " + characterName +
                " your starting weapon is " + playerWeaponType;
    }
}
