public class Input {
    int row;
    int col;
    int budget;
    int beaconPrice;
    int beaconRadius;
    Cell[][] map;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBeaconPrice() {
        return beaconPrice;
    }

    public void setBeaconPrice(int beaconPrice) {
        this.beaconPrice = beaconPrice;
    }

    public int getBeaconRadius() {
        return beaconRadius;
    }

    public void setBeaconRadius(int beaconRadius) {
        this.beaconRadius = beaconRadius;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }
}
