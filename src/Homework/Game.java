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
    // ��������������˾Ϳ��ԷŴ�. ���Ǽ�һ�������ٶ�
//    private int chargeSpeed; // ֮���ǳ���, �������Ч��, random(0-100)
    // ���뱬��

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
        System.out.printf("������ͨ: %s", intelligence);
        System.out.printf("��: %s", defence);
        System.out.printf("������: %s%%", criticalChance);
        System.out.printf("��ǰ����: %s", currentHP);
        System.out.printf("��ǰ����ֵ: %s", currentMana);
    }
}