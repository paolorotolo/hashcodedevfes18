public class MatrixSlice {
    int walls;
    int x;
    int y;

    public MatrixSlice(int walls, int x, int y) {
        this.walls = walls;
        this.x = x;
        this.y = y;
    }

    public int getWalls() {
        return walls;
    }

    public void setWalls(int walls) {
        this.walls = walls;
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
}
