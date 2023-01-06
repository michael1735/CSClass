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
    private int dexterity;
    private int criticalChance;
    private boolean alive;

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
    }
}