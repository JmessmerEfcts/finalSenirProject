package com.company;

public class Wizard extends Character{

    public Wizard(){
        super(5, "Wizard", "Sparkly fingertips", "Gandalf");
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
