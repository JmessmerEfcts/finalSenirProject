package com.company;

public class Boss extends Character{

    int bossHp;
    String bossType;
    String bossName;
    String BossWeapon;

    //this creates an empty Boss Character obj
    public Boss(){
        super(0, "Boss", "weaponHere", "NameHere");
    }

    /*
        TODO
         @ set up methods that change the bosses fields
         @ each room will make his HP higher, name different, and change his Weapon
         @ each boss will do different amounts of damage depending on the room the user is in
     */

    public String toString(){
        return "Its a " + characterType + "it looks like he's got " + hitPoints + "HP He is holding a " + characterWeaponType +
                "they call Him " + characterName;
    }








}
