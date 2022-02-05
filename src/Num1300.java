import java.util.Scanner;

public class Num1300 {

    public static long N;
    public static long k;
    public static long min = 0;
    public static long max;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        k = scanner.nextLong();
        max = k;

        //logic
        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i=1; i<=N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min);
    }
}
