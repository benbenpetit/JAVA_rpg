package rpg;

import java.util.concurrent.ThreadLocalRandom;

public class Ninja extends Character {
    private static final int generatedHp = ThreadLocalRandom.current().nextInt(20, 30 + 1);
    private static final int generatedMana = ThreadLocalRandom.current().nextInt(80, 100 + 1);
    private static final int generatedMoney = ThreadLocalRandom.current().nextInt(800, 1000 + 1);

    public Ninja(String name) {
        super(0, 0, "ninja", name, "invisibilité", generatedMoney, 0, generatedHp, generatedMana, new Katana(30, 8));
    }
}
