package rpg;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez écrire votre prénom :");
        String pseudo = scanner.next();
        System.out.println("\nVeuillez choisir une classe :");
        String classe;
        do {
            System.out.println("1- Ninja");
            System.out.println("2- Archer");
            classe = scanner.next();
        } while (!Objects.equals(classe, "1") && !Objects.equals(classe, "2"));

        Character player;
        if (Objects.equals(classe, "1")) {
            player = new Ninja(pseudo);
        } else {
            player = new Archer(pseudo);
        }

        System.out.println("\n" + player.toString() + "\n");

        Map map = new Map(10);
        map.placeObject(player);

        while (player.getHp() > 0) {
            playerMove(player, map, scanner);
            if (player.getX() == 9 && player.getY() == 9) {
                System.out.println("Gagné");
                break;
            }
        }

        if (player.getHp() <= 0) {
            System.out.println("Vous avez perdu !");
        } else {
            System.out.println("Vous avez gagné !");
        }

        scanner.close();
    }

    public static void playerMove(Character player, Map map, Scanner scanner) {
        System.out.println(map.toString());
        System.out.println(map.getDirections(player));
        System.out.println("Choisissez une des directions possibles");
        String selectedDirection = scanner.next();
        player.moveObject(selectedDirection, map, scanner);
    }

}