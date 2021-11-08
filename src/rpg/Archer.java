package rpg;

import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Character {
    private static final int generatedHp = ThreadLocalRandom.current().nextInt(15, 20 + 1);
    private static final int generatedMana = ThreadLocalRandom.current().nextInt(80, 100 + 1);
    private static final int generatedMoney = ThreadLocalRandom.current().nextInt(1800, 2000 + 1);

    public Archer(String name) {
        super(0, 0, "archer", name, "furtivité", generatedMoney, 0, generatedHp, generatedMana, new Bow(50, 10));
    }
}
