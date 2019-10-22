package field;

import boats.Boat;
import boats.PolyCellBoat;
import boats.SingleCellBoat;

public class Field {
    private Cell[][] field;

    public Field(int sizeX, int sizeY) {
        this.field = new Cell[sizeY][sizeX];
        for (int row = 0; row < sizeY; row++)
            for (int column = 0; column < sizeX; column++) {
                this.field[row][column] = new Cell(column, row);
                this.field[row][column].setField(this);
            }
    }

    public Cell getCell(int x, int y) {
        return this.field[x][y];
    }

    public boolean canPlaceBoat(Boat boat) {
        boolean result = true;
        if (boat == null) result = false;
        int x = boat.getHead().getX();
        int y = boat.getHead().getY();

        if (x < 0 || x > this.field[0].length || y < 0 || y >= this.field.length)
            result = false;
        if (!this.field[y][x].isFree())
            result = false;
        if (x > 0 && y > 0 &&(!this.field[y - 1][x - 1].isFree()))
            result = false;
        if (y > 0 && (!this.field[y - 1][x].isFree()))
            result = false;
        if (y > 0 && x < this.field[0].length - 1 && (!this.field[y - 1][x + 1].isFree()))
            result = false;
        if (x > 0 && (!this.field[y][x - 1].isFree()))
            result = false;
        if (x < this.field[0].length - 1 && (!this.field[y][x + 1].isFree()))
            result = false;
        if (y < this.field.length - 1 && x > 0 && (!this.field[y + 1][x - 1].isFree()))
            result = false;
        System.out.println(this.field[2][1].isFree());
        if (y < this.field.length - 1 && (!this.field[y + 1][x].isFree()))
            result = false;
        if (y < this.field.length - 1 && x < this.field[0].length - 1 && (!this.field[y + 1][x + 1].isFree()))
            result = false;

        if(boat instanceof PolyCellBoat) {
            Cell[] cells = boat.getBody();
            for (Cell cell : cells) {
                x = cell.getX();
                y = cell.getY();
                if (x < 0 || x > this.field[0].length || y < 0 || y >= this.field.length)
                    result = false;
                if (!this.field[y][x].isFree())
                    result = false;
                if (x > 0 && y > 0 && (!this.field[y - 1][x - 1].isFree()))
                    result = false;
                if (y > 0 && (!this.field[y - 1][x].isFree()))
                    result = false;
                if (y > 0 && x < this.field[0].length - 1 && (!this.field[y - 1][x + 1].isFree()))
                    result = false;
                if (x > 0 && (!this.field[y][x - 1].isFree()))
                    result = false;
                if (x < this.field[0].length - 1 && (!this.field[y][x].isFree()))
                    result = false;
                if (y < this.field.length - 1 && x > 0 && (!this.field[y + 1][x - 1].isFree()))
                    result = false;
                if (y < this.field.length - 1 && (!this.field[y + 1][x].isFree()))
                    result = false;
                if (y < this.field.length - 1 && x < this.field[0].length - 1 && (!this.field[y + 1][x + 1].isFree()))
                    result = false;
            }
        }
        return result;
    }

    public void setBoat(Boat boat) {
        if(canPlaceBoat(boat)) {
            boat.setHead(field[boat.getHead().getY()][boat.getHead().getX()]);
            field[boat.getHead().getY()][boat.getHead().getX()].setBoat(boat);
            System.out.println("field[" + boat.getHead().getY() + "][" + boat.getHead().getX() + "] taken");
            if (boat instanceof PolyCellBoat) {
                PolyCellBoat polyCellBoat = (PolyCellBoat) boat;
                Cell[] newBody = boat.getBody();
                int i = 0;
                for (Cell cell : polyCellBoat.getBody()) {
                    //System.out.println("field[" + cell.getY() + "][" + cell.getX() + "] taken");
                    field[cell.getY()][cell.getX()].setBoat(boat);
                    newBody[i++] = field[cell.getY()][cell.getX()];
                }
                polyCellBoat.setBody(newBody);
            }
        }
    }

    public void printField() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[0].length; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }
    }
}
