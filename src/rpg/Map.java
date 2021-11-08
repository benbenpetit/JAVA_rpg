package rpg;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
    private final Object[][] map;
    private final static String[] DIRECTIONS = {"west", "north", "east", "south"};
    private final static String[] NAMES = {"Darth Vader", "Joker", "Jack Nicholson", "Golum", "Tommy DeVito"};
    private final static String[] VILLAINS_TYPES = {"Détraqueur", "Créature ténébreuse", "Agent de sécurité", "Préface", "Patissier"};

    public Map(int mapSize) {
        this.map = new Object[mapSize][mapSize];
        this.initMap();
    }

    public void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (ThreadLocalRandom.current().nextInt(0, 6 + 1) == 1) {
                    this.map[i][j] = new Monster(
                        i, j,
                        NAMES[ThreadLocalRandom.current().nextInt(0, NAMES.length)],
                        VILLAINS_TYPES[ThreadLocalRandom.current().nextInt(0, VILLAINS_TYPES.length)],
                        new Cerveau(0, ThreadLocalRandom.current().nextInt(1, 10 + 1))
                    );
                } else {
                    this.map[i][j] = null;
                }
            }
        }

        this.map[0][0] = null;
        this.map[this.map.length-1][this.map.length-1] = null;
    }

    public void placeObject(Object object) {
        this.map[object.getX()][object.getY()] = object;
    }

    public boolean isValidDirection(Object object, String direction) {
        int x = object.getX();
        int y = object.getY();

        switch(direction) {
            case "west" :
                y--;
                break;
            case "north" :
                x--;
                break;
            case "east" :
                y++;
                break;
            case "south" :
                x++;
                break;
            default :
                return false;
        }

        if ((x >= 0 && x < this.map.length) && (y >= 0 && y < this.map.length)) {
            return true;
        }

        return false;
    }

    public StringBuilder getDirections(Object object) {
        StringBuilder str = new StringBuilder("\nLes directions possibles sont :");

        for (String direction : DIRECTIONS) {
            if (this.isValidDirection(object, direction)) {
                str.append("\n- ").append(direction);
            }
        }

        return str;
    }

    public void moveObject(Object object, int[] oldCoords, Scanner scanner) {
        if (this.map[object.getX()][object.getY()] == null) {
            this.map[oldCoords[0]][oldCoords[1]] = null;
            this.map[object.getX()][object.getY()] = object;
        } else {
            if (this.map[object.getX()][object.getY()].checkTile(object, scanner)) {
                this.map[oldCoords[0]][oldCoords[1]] = null;
                this.map[object.getX()][object.getY()] = object;
                object.regenHp(3);
                System.out.println("\n\t++++++++++\nVous avez régénéré 3 pv.\n\t++++++++++\n");
            } else {
                object.setX(oldCoords[0]);
                object.setY(oldCoords[1]);
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder("-----------------------");

        for (Object[] objects : map) {
            for (int j = 0; j < objects.length; j++) {
                if (j == 0) {
                    str.append("\n|");
                }

                if (objects[j] == null) {
                    str.append("  ");
                } else {
                    str.append(" ").append(objects[j].displaySymbol());
                }

                if (j == map.length - 1) {
                    str.append(" |");
                }
            }
        }

        str.append("\n-----------------------");

        return str.toString();
    }
}
