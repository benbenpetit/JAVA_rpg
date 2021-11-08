package rpg;

public class Cerveau extends Weapon {
    public Cerveau(int price, int damage) {
        super(price, damage, "cerveau");
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
