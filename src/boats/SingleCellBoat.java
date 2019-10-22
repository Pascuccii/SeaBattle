package boats;

import field.Cell;

public class SingleCellBoat extends Boat {
    public SingleCellBoat(Cell head) {
        super(head);
    }

    @Override
    public Cell[] getBody() {
        return new Cell[] {getHead()};
    }
}
