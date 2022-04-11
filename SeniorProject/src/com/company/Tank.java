package com.company;

public class Tank extends Character{

    public Tank(){
        super(8, "Tank", "Mace", "Bolog");
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

    public void setCharactoerWeaponType(String newCharWeapon) {
        characterWeaponType = newCharWeapon;
    }


    public String toString(){
        return super.toString();
    }

}
