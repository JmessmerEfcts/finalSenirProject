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

    int playerHp;
    String characterName;
    String classChoice;
    String playerWeaponType;

    String userName;
    String userAge;

    public Player(){
        playerHp = 0;
        characterName = "nameHere";
        classChoice = "no class";
        playerWeaponType = "no weapon";
        userName = " ";
        userAge = " ";
    }

    public  void displayClassChoices() {
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

    public String getPlayerName(){
        return characterName;
    }

    public String getPlayerClassChoice(){
        return classChoice;
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

    public void setSoldier(){
        classChoice = "Soldier";
        playerHp = soldier.getHitPoints();
        characterName = soldier.getCharacterName();
        playerWeaponType = soldier.getWeaponType();
    }

    public void setTank(){
        classChoice = "Tank";
        playerHp = tank.getHitPoints();
        characterName= tank.getCharacterName();
        playerWeaponType = tank.getWeaponType();

    }

    public void setArcher(){
        classChoice = "Archer";
        playerHp = archer.getHitPoints();
        characterName= archer.getCharacterName();
        playerWeaponType = archer.getWeaponType();

    }

    public void setWizard(){
        classChoice = "Wizard";
        playerHp = wizard.getHitPoints();
        characterName= wizard.getCharacterName();
        playerWeaponType = wizard.getWeaponType();
    }


    public String toString(){
        return "you are a " + classChoice + " with " + playerHp + "HP your Class is named " + characterName +
                " your starting weapon is " + playerWeaponType;
    }

}
