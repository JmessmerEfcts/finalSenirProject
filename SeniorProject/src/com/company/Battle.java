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
    private String userAction;

    private int bossHp;
    private int bossMaxHp;
    private int bossMinHp;
    private int bossDamage;
    private String bossWeapon;
    private String bossAction;


    /*
    the Battle constructor collects the data from the player object
    such as, health, class, weapon

    the Battle constructor also collects data from the boss object
    such as, health, and weapon, and damage

    I need to update the boss damage, it's not effecting the player
    and the boss sometimes doesn't choose a weapon
     */

     private Boss boss;
    private Player player;

    public Battle(Player Mplayer, Boss Mboss){
        player=Mplayer;
        boss = Mboss;
        playerHp = player.getPlayerHp();
        playerMaxHp = player.getPlayerMax();
        playerMinHp = player.getPlayerMin();
        playerChoice = player.getPlayerClassChoice();
        playerWeapon = player.getPlayerWeaponType();
        userAction = player.getPlayerAction();

        bossHp = boss.getBossHp();
        bossWeapon = boss.getBossWeapon();
        bossDamage = boss.getBossDamage();
    }

    //player action choices depending on the users choice of class
    public void playerActionChoices(){
        /*
        while loop until correct entry
         */



        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do? ");
        if(playerChoice.equals("Archer")) {
            String choices[] = {"quick fire bow", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();
            //quick fire bow
            if(userAction.equals(choices[0])){
                if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                    System.out.println("it has no effect");
                else
                    playerLightAttack();
            //dodge
            }else if(userAction.equals(choices[1])){
                playerLosesNoHp();
            //heal
            }else if(userAction.equals(choices[2])){
                if(playerHp == playerMaxHp) {
                    System.out.println(" Already Full health");
                    userAction = sc.nextLine();
                }else
                    playerHeal();
            }else{
                System.out.println("Please Select a valid move");
                //userAction = sc.nextLine();
            }



        }else if(playerChoice.equals("Wizard")){
            String choices[] = {"finger zap", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

            userAction = sc.nextLine();

            //finger zap
            if(userAction.equals(choices[0])){
                if(userAction.equals(choices[0])) {
                    if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                        System.out.println("it has no effect");
                    else
                        playerLightAttack();
                }
            //dodge
            }else if(userAction.equals(choices[1])){
                playerLosesNoHp();
            //heal
            }else if(userAction.equals(choices[2])){
                if(playerHp == playerMaxHp) {
                    System.out.println(" Already Full health");
                    userAction = sc.nextLine();
                }else
                    playerHeal();
            }else{
                System.out.println("Please Select a valid move");
                userAction = sc.nextLine();
            }

        }else if(playerChoice.equals("Tank")){
            String choices[] = {"Heavy Swing", "Shield Up", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();

            //Heavy Swing
            if(userAction.equals(choices[0])){
                if(bossAction.equals("Dodge") || bossAction.equals("Block"))
                    System.out.println("it has no effect");
                else
                    playerLightAttack();
            //dodge
            }else if(userAction.equals(choices[1])){
                playerLosesNoHp();

            //heal
            }else if(userAction.equals(choices[2])){
                if(playerHp == playerMaxHp) {
                    System.out.println(" Already Full health");
                    userAction = sc.nextLine();
                }else
                    playerHeal();
            }else{
                System.out.println("Please Select a valid move");
                userAction = sc.nextLine();
            }

        }else if(playerChoice.equals("Soldier")){
            String choices[] = {"Swing Sword", "Shield Up", "Dodge", "Heal"};
         for(int i = 0; i< choices.length; i++){
             System.out.print(choices[i] + " ");
         }
            userAction = sc.nextLine();
            //Swing Sword
            if(userAction.equals(choices[0])){
                if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                    System.out.println("it has no effect");
                else
                    playerLightAttack();
            //Shield Up
            }else if(userAction.equals(choices[1])){
                playerLosesNoHp();
            //dodge
            }else if(userAction.equals(choices[2])){
                playerLosesNoHp();
            //heal
            }else if(userAction.equals(choices[3])){
                if(playerHp == playerMaxHp) {
                    System.out.println(" Already Full health");
                    userAction = sc.nextLine();
                }else
                    playerHeal();
            }else{
                System.out.println("Please Select a valid move");
                userAction = sc.nextLine();
            }
        }else{
            System.out.println("outside else");
        }
    }

    public void possibleBossActions(){
        if(bossWeapon.equals("Club")){
            System.out.println("CL");
            Random rand = new Random();
            String bossActions[] = {"Swing ", " Dodge ", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];
                //swing
                if(bossAction.equals(bossActions[0])){
                    bossLightAttack();
                //dodge
                }else if(bossAction.equals(bossActions[1])){
                   enemyLosesNoHp(boss);
                 //Cry
                }else if(bossAction.equals(bossActions[2])){
                   bossLightAttack();
                }else{
                    System.out.println("boss failed to select a move in club");
                }

            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Bear Claws")){
            System.out.println("BC");
            Random rand = new Random();
            String bossActions[] = {" Scratch ", "pounce ", " Block "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];

                //scratch
                if(bossAction.equals(bossActions[0])){
                    bossLightAttack();
                //pounce
                }else if(bossAction.equals(bossActions[1])){
                    bossLightAttack();
                //block
                }else if(bossAction.equals(bossActions[2])){
                    enemyLosesNoHp(boss);
                }
                    else{
                    System.out.println("boss failed to select a move in bear claws");
                }

            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Wand")){
            System.out.println("W");
            Random rand = new Random();
            String bossActions[] = {"Zap ", " Block ", " zoop", " Cry "};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];

                //if boss chooses zap
                if(bossAction.equals(bossActions[0])){
                    //call light attack function playerHp--;
                    bossLightAttack();
                //if boss chooses Block
                }else if(bossAction.equals(bossActions[1])) {
                    //pass in a Boss/enemy obj
                    enemyLosesNoHp(boss);
                    //if boss chooses zoop
                }else if(bossAction.equals(bossActions[2])){
                    bossLightAttack();
                //cry
                }else if(bossAction.equals(bossActions[3])){
                   bossLightAttack();
                }else{
                    System.out.println("boss failed to select a move in wand");
                }

            System.out.println("your enemy Used " + bossAction);
        }else
            System.out.println("ope");
    }

    //player effects
    public void playerHeal(){
        playerHp = playerMaxHp;
        player.setPlayerHp(playerHp);
    }

    public void decreaseBossHpByOne(){
        bossHp--;
        boss.setBossHp(bossHp);
    }

   public void playerLosesNoHp(){
        int currentHealth = player.getPlayerHp();
        player.setPlayerHp(currentHealth);
   }

   public void playerLightAttack(){
        bossHp--;
        boss.setBossHp(bossHp);
   }

    //enemy effects
    //adds 1 to bossHp once the user enters a new room
    public void enemyHeal(){
        bossHp = bossMaxHp;
    }

    //adds 1 to boss damage
    public void increaseBossDamage(){
        bossDamage++;
    }


    public void bossLightAttack(){
        playerHp--;
       player.setPlayerHp(playerHp);
    }

    public void enemyLosesNoHp(Boss boss){
        int currentHealth = boss.getBossHp();
        boss.setBossHp(currentHealth);
    }
}

