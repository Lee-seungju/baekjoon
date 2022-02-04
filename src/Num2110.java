import java.util.Arrays;
import java.util.Scanner;

public class Num2110 {

    public static int N;
    public static int C;
    public static long[] Num;
    public static long min = 1;
    public static long max;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        C = scanner.nextInt();
        Num = new long[N];
        for (int i=0; i<N; i++) {
            Num[i] = scanner.nextLong();
            max = Math.max(max, Num[i]);
        }

        Arrays.sort(Num);

        //logic
        while (min < max) {
            long mid = (min + max) / 2;
            int count = 0;
            long sum = 0;
            for (long n : Num) {
                if (sum <= n) {
                    count++;
                    sum = n + mid;
                }
            }
            if (count < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min - 1);
    }
}
