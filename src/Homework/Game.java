package Homework;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
// 加入输出当前状态...
public class Game {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        String name, race, role;
        System.out.print("Please enter player1's name: ");
        name = scan.nextLine();
        System.out.print("Please enter player1's race: ");
        race = scan.nextLine();
        System.out.print("Please enter player1's role: ");
        role = scan.nextLine();
        System.out.println("Creating your character...");
        Thread.sleep(2000);
        Player player1 = new Player(name, race, role);
        System.out.println("PLAYER CREATION SUCCESSFUL!!");

        System.out.print("Please enter player2's name: ");
        name = scan.nextLine();
        System.out.print("Please enter player2's race: ");
        race = scan.nextLine();
        System.out.print("Please enter player2's role: ");
        role = scan.nextLine();
        System.out.println("Creating your character...");
        Thread.sleep(2000);
        Player player2 = new Player(name, race, role);
        System.out.println("PLAYER CREATION SUCCESSFUL!!");

        startPlay(player1, player2);
        System.out.println("The game has ended...");
        Thread.sleep(3000);
    }

    public static void startPlay(Player player1, Player player2) {
        int action;
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("Now it's player1's turn!");
            if (player1.getCurrentHP() == player1.getHP()) {
                System.out.println("You now have the following choices: ");
                System.out.println("1)attack");
                System.out.print("Choose one action: ");
                action = scan.nextInt();
                while (action != 1) {
                    System.out.println("You cannot choose the option! input again: ");
                    action = scan.nextInt();
                }
                player2.receiveDamage(player1.attack());
            } else {
                System.out.println("You now have the following choices: ");
                System.out.println("1)attack\n2)healing");
                System.out.print("Choose one action: ");
                action = scan.nextInt();
                while (action != 1 && action != 2) {
                    System.out.print("You cannot choose the option! input again: ");
                    action = scan.nextInt();
                }
                if (action == 1) {
                    player2.receiveDamage(player1.attack());
                } else {
                    player1.healing();
                }
            }
            System.out.println("Now it's player2's turn!");
            if (player1.getCurrentHP() == player1.getHP()) {
                System.out.println("You now have the following choices: ");
                System.out.println("1)attack");
                System.out.print("Choose one action: ");
                action = scan.nextInt();
                while (action != 1) {
                    System.out.println("You cannot choose the option! input again: ");
                    action = scan.nextInt();
                }
                player1.receiveDamage(player2.attack());
            } else {
                System.out.println("You now have the following choices: ");
                System.out.println("1)attack\n2)healing");
                System.out.print("Choose one action: ");
                action = scan.nextInt();
                while (action != 1 && action != 2) {
                    System.out.print("You cannot choose the option! input again: ");
                    action = scan.nextInt();
                }
                if (action == 1) {
                    player1.receiveDamage(player2.attack());
                } else {
                    player2.healing();
                }
            }
        }
    }
}

class Player {
    private int HP;
    private int mana;
    private int currentHP;
    private int currentMana;
    private String name;
    private String role;
    private String race;
    private int ATK;
    private int intelligence;
    private int defence;
    private int criticalChance;
    private boolean alive;
//    private int maxMana = 100;
    // 如果法术充能满了就可以放大. 考虑加一个充能速度
//    private int chargeSpeed; // 之后考虑充能, 加入充能效率, random(0-100)
    // 加入爆伤

    Random rnd = new Random();

    public Player(String chName, String chRace, String chRole) {
        HP = 100;
        mana = 100;
        currentHP = HP;
        currentMana = mana;
        name = chName;
        role = chRole;
        race = chRace;
        alive = true;

        ATK = rnd.nextInt(50);
        intelligence = (int) (Math.random() * 100);
        defence = (int) (Math.random() * 100);
        criticalChance = (int) (Math.random() * 100);
    }

    public void Display() {
        System.out.printf("%1$s the %2$s %3$s: ", name, race, role);
        System.out.printf("ATK: %s", ATK);
        System.out.printf("法术精通: %s", intelligence);
        System.out.printf("防: %s", defence);
        System.out.printf("暴击率: %s%%", criticalChance);
        System.out.printf("当前生命: %s", currentHP);
        System.out.printf("当前法术值: %s", currentMana);
    }

    public String getName(){
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getHP() {
        return HP;
    }

    public int attack() {
        int amountDamaged;
        if ((Math.random() * 100) <= criticalChance) {
            System.out.println("CRITICAL STRIKE!");
            amountDamaged = ATK * 2;
        } else {
            amountDamaged = ATK;
        }
        System.out.println(name + " attacked for " + amountDamaged);
        return amountDamaged;
    }

    public void receiveDamage(int damage) {
        HP -= damage;
        if (currentHP <= 0) {
            currentHP = 0;
            alive = false;
            System.out.println(name + " has died");
        }
    }

    public void healing() {
        int amountHealed = 0;
        if ((Math.random() * 100) <= criticalChance) {
            amountHealed += (Math.random() * intelligence) * 2;
            System.out.println("DOUBLE HEALING!!!");
            System.out.printf("You recovered %s", amountHealed);
        }
        currentMana -= 10;
        currentHP += amountHealed;
        if (currentHP > HP) {
            currentHP = HP;
        }
        System.out.printf("%s's HP is now %d", name, currentHP);
    }

    // e技能和大以后再说
}