public class Cell {

    public Cell(int type) {
        this.type = type;
    }

    static final int CELL_WALL = 0;
    static final int CELL_EMPTY = 1;
    static final int CELL_BEACON = 2;

    int type;
    int x;
    int y;

    int beaconCount = 0;

}
