import java.util.Scanner;

public class Num2512 {

    public static int N;
    public static long[] Num;
    public static long M;
    public static long min = 0;
    public static long max = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new long[N];
        String[] a = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            Num[i] = Long.parseLong(a[i]);
            min = Math.min(min, Num[i]);
            max = Math.max(max, Num[i]);
        }
        M = Long.parseLong(scanner.nextLine());
        max += 1;

        //logic
        while (min < max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (long n : Num) {
                if (n > mid)
                    sum += mid;
                else
                    sum += n;
            }
            if (sum > M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min - 1);
    }
}
