package Homework;

import java.util.Random;

public class Game {
    public static void main(String[] args) {

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
}