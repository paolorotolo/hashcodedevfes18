import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputParser {
    public static Input parseInput(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String firstLine = bufferedReader.readLine();

        Input input = new Input();
        Scanner scanner = new Scanner(firstLine);

        input.row = scanner.nextInt();
        input.col = scanner.nextInt();
        input.budget = scanner.nextInt();
        input.beaconPrice = scanner.nextInt();
        input.beaconRadius = scanner.nextInt();

        Cell[][] map = new Cell[input.row][input.col];

        for (int curRow=0; curRow<input.row; curRow++) {
            String currentLine = bufferedReader.readLine();

            for (int curCol = 0; curCol < input.col; curCol++) {
                char curChar = currentLine.charAt(curCol);

                if (curChar == '#') {
                    map[curRow][curCol] = new Cell(Cell.CELL_WALL);
                } else {
                    map[curRow][curCol] = new Cell(Cell.CELL_EMPTY);
                }

                map[curRow][curCol].x = curRow;
                map[curRow][curCol].y = curCol;
            }
        }

        input.map = map;

        return input;


    }
}
