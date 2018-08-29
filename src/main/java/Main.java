import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){

        try {
            Input input = InputParser.parseInput("/home/paolo/Downloads/museum.in");

            Cell[][] matrix = input.map;

            int windowRadius = input.beaconRadius*2+1;
            int maxBeacons = input.budget / input.beaconPrice;

            List<MatrixSlice> slices = new ArrayList<>();



            System.out.println(input.row-(input.row%windowRadius));

            for (int i=0; i<input.col-(input.col%windowRadius); i=i+windowRadius) {
                for (int j=0; j<input.row-(input.row%windowRadius); j= j+windowRadius) {

                    int wallCount = 0;

                    for (int k=0+(i*windowRadius); k<windowRadius; k++) {
                        for (int l=0+(j*windowRadius); l<windowRadius; l++) {
                            if (matrix[k][l].type == Cell.CELL_WALL) {
                                wallCount++;

                            }
                        }
                    }

                    slices.add(new MatrixSlice(wallCount, i, j));
                }
            }

            sortForWallCount(slices);

            for (MatrixSlice slice : slices) {
                int x = slice.x;
                int y = slice.y;

                input.map[x][y].type = Cell.CELL_BEACON;
                input.map[x][y+input.beaconRadius-1].type = Cell.CELL_BEACON;
                input.map[x+input.beaconRadius-1][y].type = Cell.CELL_BEACON;
            }

            List<Beacon> beacons = new ArrayList<>();
            int price = 0;
            for (int i=0; i<input.row; i++) {
                for (int j=0; j<input.col; j++) {
                    if (input.map[i][j].type == Cell.CELL_BEACON && (input.budget - input.beaconPrice)>= price) {
                        beacons.add(new Beacon(i, j));
                        price += input.beaconPrice;
                    }

                }
            }


            print(beacons);



        } catch (IOException e) {
            e.printStackTrace();
        }







    }

    private static void print(List<Beacon> beacons){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/paolo/output.txt"));

            writer.write(beacons.size() + "");

            for (Beacon b : beacons) {
                writer.write("\n");
                writer.write(b.x + "");
                writer.write(b.y + "");
            }

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortForWallCount(List<MatrixSlice> array) {

        Collections.sort(array, Comparator.comparingInt(MatrixSlice::getWalls));
    }






    private static List<Cell> matrixToArray(Cell[][] arr) {
        List<Cell> list = new ArrayList<Cell>();
        for (int i = 0; i < arr.length; i++) {
            // tiny change 1: proper dimensions
            for (int j = 0; j < arr[i].length; j++) {
                // tiny change 2: actually store the values
                list.add(arr[i][j]);
            }
        }
        return list;
    }


}