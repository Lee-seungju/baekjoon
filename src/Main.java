import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static long NumZero[];
    public static long NumOne[];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        NumZero = new long[N+1];
        NumOne = new long[N+1];

        //logic
        NumZero[1] = 0;
        NumOne[1] = 1;
        for (int i=2; i<=N; i++) {
            NumOne[i] = NumZero[i-1];
            NumZero[i] = NumOne[i-1] +NumZero[i-1];
        }

        //output
        System.out.println(NumOne[N] + NumZero[N]);
    }
}