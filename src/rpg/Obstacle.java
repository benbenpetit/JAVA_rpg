package rpg;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Obstacle extends Destructible {
    private static final int generatedHp = ThreadLocalRandom.current().nextInt(1, 6 + 1);

    public Obstacle(int x, int y, String name) {
        super(x, y, generatedHp, name);
    }

    public Obstacle(String name) {
        super(0, 0, generatedHp, name);
    }

    public Obstacle(int x, int y, String name, double multiplier) {
        super(x, y, generatedHp, name, multiplier);
    }

    public Obstacle(String name, double multiplier) {
        super(0, 0, generatedHp, name, multiplier);
    }

    @Override
    public String displaySymbol() {
        return "X";
    }

    @Override
    public boolean checkTile(Object object, Scanner scanner) {
        return false;
    }
}
