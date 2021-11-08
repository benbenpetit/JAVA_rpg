package rpg;

public class Bow extends Weapon {
    public Bow(int price, int damage) {
        super(price, damage, "arc");
    }

    public String ascii_art() {
        return
                """
                                  
                                  4$$-.                       \s
                                   4   ".                                       \s
                                   4    ^.                                      \s
                                   4     $                                      \s
                                   4     'b                                     \s
                                   4      "b.                                   \s
                                   4        $                                   \s
                                   4        $r                                  \s
                                   4        $F                                  \s
                        -$b========4========$b====*P=-                          \s
                                   4       *$$F                                 \s
                                   4        $$"                                 \s
                                   4       .$F                                  \s
                                   4       dP                                   \s
                                   4      F                                     \s
                                   4     @                                      \s
                                   4    .                                       \s
                                   J.                                           \s
                                  '$$
                """;
    }
}
