package field;

import boats.Boat;

public class Cell {
    private int x;
    private int y;
    private boolean isStriked;
    private Boat boat;
    private Field field;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isStriked() {
        return isStriked;
    }

    public void setStriked(boolean striked) {
        isStriked = striked;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isFree() {
        return this.boat == null;
    }

    @Override
    public String toString() {
        return this.boat == null ? "_" : "0";
    }
}
