import java.util.Scanner;

public class Num1018 {

    public static int N;
    public static int M;
    public static String[][] sample1 = new String[8][8];
    public static String[][] sample2 = new String[8][8];

    public static String[][] board;

    public static int min = 64;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        board = new String[N][M];
        for (int i=0; i<N; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j=0; j<M; j++) {
                board[i][j] = line[j];
            }
        }

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if ((i+j)%2 == 1) {
                    sample1[i][j] = "B";
                    sample2[i][j] = "W";
                }
                else {
                    sample1[i][j] = "W";
                    sample2[i][j] = "B";
                }
            }
        }

        // logic
        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                int count1 = 0;
                int count2 = 0;
                for (int i1=0; i1<8; i1++) {
                    for (int j1=0; j1<8; j1++) {
                        if (!sample1[i1][j1].equals(board[i+i1][j+j1])) {
                            count1++;
                        }
                        if (!sample2[i1][j1].equals(board[i+i1][j+j1]))
                            count2++;
                    }
                }
                if (min > count1)
                    min = count1;
                if (min > count2)
                    min = count2;
            }
        }

        //output
        System.out.println(min);
    }
}
