package com.company;

import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class Boss {

    //array stroing all the possible weapons the bosses can randomly use
    String WeaponArr[] = {"Club", "Bear Claws", "Wand", "Bat"};

    int bossHp;
    String bossName;
    String bossWeapon;
    int roomNumber;
    int bossDamage;

    //this creates an empty Boss obj
    public Boss(int bossHp, String bossName, String bossWeapon, int roomNumber, int bossDamage){
       this.bossHp = bossHp;
       this.bossName = bossName;
       this.bossWeapon = bossWeapon;
       this.roomNumber = roomNumber;
       this.bossDamage = bossDamage;
    }

    public Boss(){
        this.bossHp = 8;
        this.bossName = " ";
        this.bossWeapon = " ";
        this.roomNumber = 1;
        this.bossDamage = 3;
    }


    //getters
    public int getBossHp(){
        return bossHp;
    }

    public String getBossName(){
        return bossName;
    }

    public String getBossWeapon(){
        return bossWeapon;
    }

    public int getStartingRoom(){
        return roomNumber;
    }

    //setters
    public void setBossHp(int bossHp) {
        this.bossHp = bossHp;
    }

    public void setBossName(String bossName){
        this.bossName = bossName;
    }

    public void setBossWeapon(){
        Random rand = new Random();
        //set upperbound to lenght of the String array containing weapons
        int upperBound = WeaponArr.length;
        //generate random value
        int randoNum = rand.nextInt(upperBound);
        //select a random index from weaponArr using randomNum
        String bossWeapon = WeaponArr[randoNum];
        this.bossWeapon = bossWeapon;
    }

    public void setStartingRoom(int startingRoom){
        this.roomNumber = startingRoom;
    }


    //adds 1 to bossHp once the user enters a new room
    public void increaseHp(){
        bossHp++;
    }

    //adds 1 to boss damage
    public void increaseBossDamage(){
        bossDamage++;
    }


    public void possibleBossActions(){
        if(bossWeapon.equals("Club")){
            Random rand = new Random();
            String bossActions[] = {"Swing ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

            System.out.println(bossName + " Used " + selectedAction);

        }else if(bossWeapon.equals("Bear Claws")){
            Random rand = new Random();
            String bossActions[] = {"Scratch ", "pounce ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

            System.out.println(bossName + " Used " + selectedAction);

        }else if(bossWeapon.equals("Wand")){
            Random rand = new Random();
            String bossActions[] = {"Zap ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

            System.out.println(bossName + " Used " + selectedAction);

        }else if(bossWeapon.equals("Wand")) {
            Random rand = new Random();
            String bossActions[] = {"Zap ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

            System.out.println(bossName + " Used " + selectedAction);

        }else
            System.out.println("ope");

    }

    /*
        TODO
         @ each room will make his HP higher, name different, and change his Weapon
         @ each boss will do different amounts of damage depending on the room the user is in
     */

    public String toString(){
        return "Its a Horrible Creature " + "it looks like he's got " + bossHp + " HP He is holding a " + bossWeapon +
                " they call Him " + bossName;
    }
}
