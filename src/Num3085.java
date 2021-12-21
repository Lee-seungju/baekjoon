import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num3085 {
    public static int num;
    public static List<String[]> board;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        num = Integer.parseInt(scanner.nextLine());
        board = new ArrayList<>();
        for (int i=0; i<num;i++) {
            board.add(scanner.nextLine().split(""));
        }

        //logic
        int count = 0;
        for (int i=0; i<num; i++) {
            for (int j=0; j<num-1; j++) {
                String tmp = (board.get(i))[j];
                (board.get(i))[j] = (board.get(i))[j+1];
                (board.get(i))[j+1] = tmp;

                countString();

                (board.get(i))[j+1] = (board.get(i))[j];
                (board.get(i))[j] = tmp;
            }
        }

        for (int i=0; i<num; i++) {
            for (int j=0; j<num-1; j++) {
                String tmp = (board.get(j))[i];
                (board.get(j))[i] = (board.get(j+1))[i];
                (board.get(j+1))[i] = tmp;

                countString();

                (board.get(j+1))[i] = (board.get(j))[i];
                (board.get(j))[i] = tmp;
            }
        }

        //output
        System.out.println(max);
    }

    public static void countString() {
        for (int i = 0; i < num; i++) {
            int count = 1;

            for (int j = 0; j < num - 1; j++) {
                if ((board.get(i)[j]).equals((board.get(i))[j + 1])) {
                    count ++;
                }
                else {
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }

        for (int i = 0; i < num; i++) {
            int count = 1;
            for (int j = 0; j < num - 1; j++) {
                if ((board.get(j))[i].equals((board.get(j + 1))[i])) {
                    count++;
                }
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
    }
}
