import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int T;
    public static int N[];
    public static int firstNum[][];
    public static int secondNum[][];
    public static int result[][];


    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        T = Integer.parseInt(scanner.nextLine());
        N = new int[T];
        firstNum = new int[T][1000001];
        secondNum = new int[T][1000001];
        for (int i=0; i<T; i++) {
            N[i] = Integer.parseInt(scanner.nextLine());
            String[] a = scanner.nextLine().split(" ");
            for (int j=1; j <= N[i]; j++) {
                firstNum[i][j] = Integer.parseInt(a[j - 1]);
            }
            a = scanner.nextLine().split(" ");
            for (int j=1; j <= N[i]; j++) {
                secondNum[i][j] = Integer.parseInt(a[j - 1]);
            }
        }

        //logic
        for (int i=0; i<T; i++) {
            result = new int[2][1000001];
            result[0][0] = 0;
            result[1][0] = 0;
            result[0][1] = firstNum[i][1];
            result[1][1] = secondNum[i][1];
            for (int j=2; j <= N[i]; j++) {
                result[0][j] = Math.max(result[1][j - 1], result[1][j - 2]) + firstNum[i][j];
                result[1][j] += Math.max(result[0][j - 1], result[0][j - 2]) + secondNum[i][j];
            }
            int max = 0;
            for (int j=0; j <= N[i]; j++) {
                max = Math.max(max, result[1][j]);
                max = Math.max(max, result[0][j]);
            }
            System.out.println(max);
        }

        //output
    }
}