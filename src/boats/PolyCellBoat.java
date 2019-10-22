package boats;

import field.Cell;

public class PolyCellBoat extends Boat {
    private Cell[] body;

    public PolyCellBoat(Cell head, int amountOfCells, boolean isVertical) {
        super(head);
        body = new Cell[amountOfCells];
        int increase = 0;
        for (int i = 0; i < amountOfCells; i++)
            body[i] = isVertical ?
                    (new Cell(head.getX(), head.getY() + increase++)) :
                    (new Cell(head.getX() + increase++, head.getY()));

    }

    @Override
    public Cell[] getBody() {
        return body;
    }

    public void setBody(Cell[] body) {
        this.body = body;
    }
}
