package rpg;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Destructible {
    public String monster;

    public Monster(int x, int y, String name, String monster, Weapon weapon) {
        super(x, y, ThreadLocalRandom.current().nextInt(10, 15 + 1), name, weapon);
        this.monster = monster;
    }

    public Monster(int x, int y, String name, double multiplier, String monster, Weapon weapon) {
        super(x, y, ThreadLocalRandom.current().nextInt(5, 10 + 1), name, multiplier, weapon);
        this.monster = monster;
    }

    public Monster(String name, String monster, Weapon weapon) {
        super(0, 0, ThreadLocalRandom.current().nextInt(5, 10 + 1), name, weapon);
        this.monster = monster;
    }

    public Monster(String name, double multiplier, String monster, Weapon weapon) {
        super(0, 0, ThreadLocalRandom.current().nextInt(5, 10 + 1), name, multiplier, weapon);
        this.monster = monster;
    }

    @Override
    public String displaySymbol() {
        return "M";
    }

    @Override
    public boolean checkTile(Object object, Scanner scanner) {
        return this.fight((Character)object, scanner);
    }

    public boolean fight(Character player, Scanner scanner) {
        Monster ennemy = this;
        System.out.println("\n------------------\n" + ennemy.toString() + "\n");

        while (player.getHp() > 0 && ennemy.getHp() > 0) {
            System.out.println("Vous pouvez \"attaquer\" ou \"fuir\" :");
            System.out.println("Vous possédez " + player.getHp() + "/" + player.getMaxHp() + " pv.");
            System.out.println("L'ennemi possède " + ennemy.getHp() + "/" + ennemy.getMaxHp() + " pv.");
            String decision = scanner.next();

            if (Objects.equals(decision, "attaquer")) {
                ennemy.takeDamage(player.weapon.getDamage());
                if (ennemy.getHp() > 0) {
                    player.takeDamage(ennemy.weapon.getDamage());
                }
            } else if (Objects.equals(decision, "fuir")) {
                return false;
            }
        }

        if (player.getHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getMonster() {
        return this.monster;
    }

    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1) + " est un " + this.monster + ". Il possède " + this.hp + "/" + super.maxHp + " pv.";
    }
}
