package rpg;

import java.util.Scanner;

public abstract class Character extends Destructible {
    public String character;
    public String spell;
    public double money;
    public double xp;
    public int mana;
    public int maxMana;

    public Character(int x, int y, String character, String name, String spell, double money, double xp, int maxHp, int maxMana, Weapon weapon) {
        super(x, y, maxHp, name, weapon);
        this.character = character;
        this.spell = spell;
        this.money = money;
        this.xp = xp;
        this.mana = maxMana;
        this.maxMana = maxMana;
    }

    public String getSpell() {
        return spell;
    }

    @Override
    public String displaySymbol() {
        return "O";
    }

    @Override
    public boolean checkTile(Object object, Scanner scanner) {
        return true;
    }

    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1) + " est un " + character + ".\nIl possède " + money + "€, " + xp + " d'expérience et " + mana + " points de mana.\nSon arme est " + weapon.getName() + " faisant " + weapon.getDamage() + " de dégats.";
    }
}