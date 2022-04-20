package com.company;

import java.util.Random;
import java.util.Scanner;

public class Battle{
    Scanner sc = new Scanner(System.in);

    private int playerHp;
    private int playerMaxHp;
    private int playerMinHp;
    private String playerChoice;
    private String playerWeapon;

    private int bossHp;
    private int bossMaxHp;
    private int bossMinHp;
    private int bossDamage;
    private String bossWeapon;


    /*
    the Battle constructor collects the data from the player object
    such as, health, class, weapon

    the Battle constructor also collects data from the boss object
    such as, health, and weapon, and damage

    I need to update the boss damage, it's not effecting the player
    and the boss sometimes doesn't choose a weapon
     */

    public Battle(Player player, Boss boss){
        playerHp = player.getPlayerHp();
        playerChoice = player.getPlayerClassChoice();
        playerWeapon = player.getPlayerWeaponType();

        bossHp = boss.getBossHp();
        bossWeapon = boss.getBossWeapon();
        bossDamage = boss.getBossDamage();
    }

    //player action choices depending on the users choice of class
    public void playerActionChoices(){
        System.out.println("What would you like to do? ");
        if(playerChoice.equals("Archer")) {
            String choices[] = {"quick fire bow,", " Dodge ", " Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

        }else if(playerChoice.equals("Wizard")){
            String choices[] = {"finger zap,", "Dodge", " Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

        }else if(playerChoice.equals("Tank")){
            String choices[] = {"Heavy Swing,", "Shield Up ", " Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

        }else if(playerChoice.equals("Soldier")){
            String choices[] = {"Swing Sword,", " Shield Up ", " Dodge ", " Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
        }
    }

    public void possibleBossActions(){
        if(bossWeapon.equals("Club")){
            System.out.println("CL");
            Random rand = new Random();
            String bossActions[] = {"Swing ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

                if(selectedAction.equals(bossActions[0])){
                    decreasePlayerHpByOne();
                }else if(selectedAction.equals(bossActions[1])){
                    enemyLosesNoHp();
                }else{
                    System.out.println("Please select a valid Move");
                }

            System.out.println("your enemy Used " + selectedAction);

        }else if(bossWeapon.equals("Bear Claws")){
            System.out.println("BC");
            Random rand = new Random();
            String bossActions[] = {" Scratch ", "pounce ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

                if(selectedAction.equals(bossActions[0])){
                    decreasePlayerHpByOne();
                }else if(selectedAction.equals(bossActions[1])){
                    enemyLosesNoHp();
                }else{
                    System.out.println("Please select a valid Move");
                }

            System.out.println("your enemy Used " + selectedAction);

        }else if(bossWeapon.equals("Wand")){
            System.out.println("W");
            Random rand = new Random();
            String bossActions[] = {"Zap ", " Block ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            String selectedAction = bossActions[randomBossAction];

                if(selectedAction.equals(bossActions[0])){
                    decreasePlayerHpByOne();

                }else if(selectedAction.equals(bossActions[1])){
                    enemyLosesNoHp();
                }else{
                    System.out.println("Please select a valid Move");
                }

            System.out.println("your enemy Used " + selectedAction);
        }else
            System.out.println("ope");
    }

    //player effects
    public void decreaseBossHpByOne(){
        bossHp--;
    }

   public void playerLosesNoHp(){
        this.playerHp = playerHp;
   }

    //enemy effects
    //adds 1 to bossHp once the user enters a new room
    public void increaseHp(){
        bossHp++;
    }

    //adds 1 to boss damage
    public void increaseBossDamage(){
        bossDamage++;
    }


    public void decreasePlayerHpByOne(){
        playerHp--;
    }

    public void enemyLosesNoHp(){
        this.bossHp = bossHp;
    }

    //calls function to lower player health
    public void bossLightAttack(){
        decreasePlayerHpByOne();
    }

}
