package com.company;

public class Character {
    int hitPoints = 0;
    String characterType;
    String characterWeaponType;
    String characterName;

    //constructor for Bosses
//    public Character(){
//        hitPoints = 0;
//        characterType = "";
//        characterName = "";
//        charactoerWeaponType = "";
//    }

    //constructor for player Choices
    public Character(int hp, String type, String weapon, String name){
        hitPoints = hp;
        characterType = type;
        characterName = name;
        characterWeaponType = weapon;
    }



    //getters
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
        return characterWeaponType;
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

    public void setCharacterWeaponType(String newCharWeapon) {
        characterWeaponType = newCharWeapon;
    }

    public String toString(){
        return "you're a Character of " + characterType + " type. You have " + hitPoints + " hitPoints " + "/n" +
                "your starting weapon is a " + characterWeaponType;
    }
}
