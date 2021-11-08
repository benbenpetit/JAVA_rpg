package rpg;

public class Katana extends Weapon {
    public Katana(int price, int damage) {
        super(price, damage, "katana");
    }

    public String ascii_art() {
        return
                """
                                      
                                      / \\                               ______,....----,
                        /VVVVVVVVVVVVVV|===================""\"""\"""\"""\"       ___,..-'
                        `^^^^^^^^^^^^^^|======================----------""\"""\"
                                      \\/
                """;
    }
}
