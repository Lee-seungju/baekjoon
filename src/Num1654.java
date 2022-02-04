import java.util.Scanner;

public class Num1654 {

    public static int K;
    public static long N;
    public static long[] Num;
    public static long min;
    public static long max;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        K = Integer.parseInt(a[0]);
        N = Integer.parseInt(a[1]);
        Num = new long[K];
        for (int i=0; i<K; i++) {
            Num[i] = Integer.parseInt(scanner.nextLine());
            max = Math.max(Num[i], max);
        }

        //logic
        max++;
        while (min < max) {
            long mid = (min + max) / 2;
            int count = 0;
            for (long n : Num) {
                count += n / mid;
            }
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min - 1);
    }
}
