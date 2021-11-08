package rpg;

import java.util.Scanner;

public abstract class Object {
    public int x;
    public int y;

    public Object() {
        this.x = 0;
        this.y = 0;
    }

    public Object(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveObject(String direction, Map map, Scanner scanner) {
        if (map.isValidDirection(this, direction)) {
            int[] oldPoint = {this.x, this.y};

            switch (direction) {
                case "north" -> this.x--;
                case "south" -> this.x++;
                case "west" -> this.y--;
                case "east" -> this.y++;
            }

            map.moveObject((Character) this, oldPoint, scanner);
        }
    }

    public abstract String displaySymbol();

    public abstract boolean checkTile(Object object, Scanner scanner);

    public abstract void regenHp(int hp);
}
