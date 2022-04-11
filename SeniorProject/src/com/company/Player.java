package com.company;

import com.sun.xml.internal.bind.v2.TODO;

public class Player {

    Soldier soldier = new Soldier();
    Tank tank = new Tank();
    Archer archer = new Archer();
    Wizard wizard = new Wizard();

    // array storing possible class selections for user
    Character characterArr[] = {soldier, tank, archer, wizard};

    int playerHp;
    String playerName;
    String classChoice;
    String playerWeaponType;

    public Player(){
        playerHp = 0;
        playerName = "nameHere";
        classChoice = "no class";
        playerWeaponType = "no weapon";
    }


    //getters
    public int getPlayerHp(){
        return playerHp;
    }

    public String getPlayerName(){
        return playerName;
    }

    public String getPlayerClassChoice(){
        return classChoice;
    }

    public String getPlayerWeaponType(){
        return playerWeaponType;
    }

    //setters
    public void setSoldier(){
        classChoice = "Soldier";
        playerHp = soldier.getHitPoints();
        playerName = soldier.getCharacterName();
        playerWeaponType = soldier.getWeaponType();
    }

    public void setTank(){

    }

    //TODO toString() method in player class or somewhere else?

}
