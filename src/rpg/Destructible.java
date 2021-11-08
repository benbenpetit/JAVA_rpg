package rpg;

public abstract class Destructible extends Object {
    public double hp;
    public final double maxHp;
    public final String name;
    public final double multiplier;
    public final Weapon weapon;

    public Destructible(int x, int y, double maxHp, String name) {
        super(x, y);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.name = name;
        this.multiplier = 1;
        this.weapon = new Katana(0, 0);
    }

    public Destructible(int x, int y, double maxHp, String name, Weapon weapon) {
        super(x, y);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.name = name;
        this.multiplier = 1;
        this.weapon = weapon;
    }

    public Destructible(int x, int y, double maxHp, String name, double multiplier) {
        super(x, y);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.name = name;
        this.multiplier = multiplier;
        this.weapon = new Katana(0, 0);
    }

    public Destructible(int x, int y, double maxHp, String name, double multiplier, Weapon weapon) {
        super(x, y);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.name = name;
        this.multiplier = multiplier;
        this.weapon = weapon;
    }

    public void takeDamage(double damage) {
        this.hp -= damage * multiplier;
    }

    @Override
    public void regenHp(int hp) {
        if (this.hp + hp > this.maxHp) {
            this.hp = this.maxHp;
        } else {
            this.hp += 5;
        }
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public String toString() {
        return name + " possède " + hp + "/" + maxHp + " pv.";
    }
}