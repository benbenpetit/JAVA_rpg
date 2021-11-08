package rpg;

public abstract class Weapon {
    private int price;
    private int damage;
    private String name;

    public Weapon(int price, int damage, String name) {
        this.price = price;
        this.damage = damage;
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public abstract String ascii_art();

    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1) + " au prix de " + price + "€ : " + damage + " de dégats";
    }
}