import java.io.IOException;

public class Main {

    public static void main(String[] args){

        try {
            Input input = InputParser.parseInput("/home/paolo/Downloads/example.in");

            for (int i=0; i<input.row; i++) {
                for (int j=0; j<input.col; j++) {
                    System.out.print(input.map[i][j].type + "");
                }
                System.out.println("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}