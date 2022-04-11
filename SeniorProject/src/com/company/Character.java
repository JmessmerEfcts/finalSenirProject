package com.company;

public class Character {
    int hitPoints = 0;
    String characterType;
    String charactoerWeaponType;
    String characterName;

    public Character(int hp, String type, String weapon, String name){
        hitPoints = hp;
        characterType = type;
        characterName = name;
        charactoerWeaponType = weapon;
    }


    //getter
    public int getHitPoints(){
        return hitPoints;
    }

    public String getCharacterType() {
        return characterType;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getWeaponType(){
        return charactoerWeaponType;
    }

    //setters
    public void setHitPoints(int newHp){
        hitPoints = newHp;
    }

    public void setCharacterType(String newCharType){
        characterType = newCharType;
    }

    public void setCharacterName(String newCharName){
        characterName = newCharName;
    }

    public void setCharactoerWeaponType(String newCharWeapon) {
        charactoerWeaponType = newCharWeapon;
    }

    public String toString(){
        return "you're a Character of " + characterType + " type. You have " + hitPoints + " hitPoints " + "/n" +
                "your starting weapon is a " + charactoerWeaponType;
    }
}

