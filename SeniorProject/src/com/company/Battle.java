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
            String choices[] = {"Quick Fire Bow", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();
            //quick fire bow
            if(userAction.equals(choices[0])){
                player.setPlayerAction(userAction);
            //dodge
            }else if(userAction.equals(choices[1])){
                player.setPlayerAction(userAction);
                playerLosesNoHp();
            //heal
            }else if(userAction.equals(choices[2])){
                player.setPlayerAction(userAction);
            }else{
                System.out.println("Please Select a valid move");
                userAction = sc.nextLine();

            }

        }else if(playerChoice.equals("Wizard")){
            String choices[] = {"Finger Zap", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

            userAction = sc.nextLine();

            //finger zap
            if(userAction.equals(choices[0])){
                player.setPlayerAction(userAction);
                System.out.println("Test: " + player.getPlayerAction());
//
            //dodge
            }else if(userAction.equals(choices[1])){
                player.setPlayerAction(userAction);
                System.out.println("Test: " + player.getPlayerAction());
                playerLosesNoHp();
            //heal
            }else if(userAction.equals(choices[2])){
                userAction = "Heal";
                player.setPlayerAction(userAction);
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
                player.setPlayerAction(userAction);
            //Shield Up
            }else if(userAction.equals(choices[1])){
                player.setPlayerAction(userAction);

            //heal
            }else if(userAction.equals(choices[2])){
                player.setPlayerAction(userAction);

            }else{
                System.out.println("Please Select a valid move");
                userAction = sc.nextLine();
            }


        }else if(playerChoice.equals("Soldier")){
            String choices[] = {"Swing Sword", "Dodge", "Heal"};
            for(int i = 0; i< choices.length; i++){
                 System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();

            //Swing Sword
            if(userAction.equals(choices[0])) {
                player.setPlayerAction(userAction);

            //dodge
            }
            else if(userAction.equals(choices[1])){
                player.setPlayerAction(userAction);

            //heal
            }else if(userAction.equals(choices[2])){
                player.setPlayerAction(userAction);
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
            String bossActions[] = {"Swing", "Dodge", "Cry"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];
                //swing
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //dodge
                }else if(bossAction.equals(bossActions[1])){
                    boss.setBossAction(bossAction);
                 //Cry
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                }else{
                    System.out.println("boss failed to select a move in club");
                }

            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Bear Claws")){
            System.out.println("BC");
            Random rand = new Random();
            String bossActions[] = {"Scratch", "Pounce", "Block"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];

                //scratch
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //pounce
                }else if(bossAction.equals(bossActions[1])){
                    boss.setBossAction(bossAction);
                //block
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                }
                    else{
                    System.out.println("boss failed to select a move in bear claws");
                }

            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Wand")){
            System.out.println("W");
            Random rand = new Random();
            String bossActions[] = {"Zap", "Block", "Zoop", "Cry"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];

                //if boss chooses zap
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //if boss chooses Block
                }else if(bossAction.equals(bossActions[1])) {
                    boss.setBossAction(bossAction);

                //if boss chooses zoop
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                //cry
                }else if(bossAction.equals(bossActions[3])){
                    boss.setBossAction(bossAction);
                }else{
                    System.out.println("boss failed to select a move in wand");
                }

            System.out.println("your enemy Used " + bossAction);
        }else
            System.out.println("ope");
    }


    public void calculateResults(){
        try {
            userAction = player.getPlayerAction();
                //calculate soldier moves
                if(userAction.equals("Swing Sword")){
                    if(bossAction.equals("Dodge") || bossAction.equals("Block")){
                        enemyLosesNoHp();
                    }else
                        playerLightAttack();
                }else if(userAction.equals("Dodge")){
                    playerLosesNoHp();
                }else if(userAction.equals("Heal")) {
                    if(playerHp == playerMaxHp) {
                        System.out.println(" Already Full health");
                        userAction = sc.nextLine();
                    }else
                        playerHeal();
                }else
                   // System.out.println("CalculateResults: Solder");

                //calculate tank moves
                if(userAction.equals("Heavy Swing")){
                    if(bossAction.equals("Dodge") || bossAction.equals("Block")){
                        System.out.println("it has no effect");
                    }else{
                        playerLightAttack();
                    }
                }else if(userAction.equals("Shield Up")){
                    playerLosesNoHp();
                }else if(userAction.equals("Heal")){
                    if(playerHp == playerMaxHp) {
                       System.out.println(" Already Full health");
                        userAction = sc.nextLine();
                    }else
                        playerHeal();
                }else
                    System.out.println("CalculateResults: Tank");

                //calculate wizard moves
                if(userAction.equals("Finger Zap")){
                    if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                        System.out.println("it has no effect");
                    else
                        playerLightAttack();
                }else if(userAction.equals("Dodge")){
                    playerLosesNoHp();
                }else if(userAction.equals("Heal")){
                    if(playerHp == playerMaxHp) {
                        System.out.println(" Already Full health");
                        userAction = sc.nextLine();
                    }else
                        playerHeal();
                }else
                   // System.out.println("CalculateResults: Wizard");

                //calculate archer moves{
                if(userAction.equals("Quick fire bow")){
                    if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                        System.out.println("it has no effect");
                    else
                        playerLightAttack();
                }else if(userAction.equals("Dodge"))
                    playerLosesNoHp();
                else if(userAction.equals("Heal")){
                    if(playerHp == playerMaxHp) {
                        System.out.println(" Already Full health");
                        userAction = sc.nextLine();
                    }else
                        playerHeal();
                }

            bossAction = boss.getBossAction();

            //Calculate moves for club
            if(bossAction.equals("Swing")){
                if(userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();

            }else if(bossAction.equals("Dodge")){
                enemyLosesNoHp();
            }else if(bossAction.equals("Cry")){
               System.out.println("He is very sad");
            }

            //calculate moves for Bear Claws
            if(bossAction.equals("Scratch")){
                if(userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();
            }else if(bossAction.equals("Pounce")) {
                if (userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();
            }else if(bossAction.equals("Block")){
                enemyLosesNoHp();
            }

            //Calculate Moves for wand
            if (bossAction.equals("Zap")){
                if(userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();
            }else if(bossAction.equals("Block")){
                enemyLosesNoHp();
            }else if(bossAction.equals("Zoop")){
                if(userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();
            }else if(bossAction.equals("Cry"))
                System.out.println("He is Very Sad");


            System.out.println("Player action " + userAction);
            System.out.println("Boss Action " + bossAction);

        }catch(Exception e){
            System.out.println(e);
        }
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

    public void enemyLosesNoHp(){
        int currentHealth = boss.getBossHp();
        boss.setBossHp(currentHealth);
    }
}

