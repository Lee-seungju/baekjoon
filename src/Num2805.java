import java.util.Scanner;

public class Num2805 {

    public static int N;
    public static long M;
    public static long[] trees;
    public static long Max = 0;
    public static long Min = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        trees = new long[N];
        String[] b = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            trees[i] = Long.parseLong(b[i]);
            Max = Math.max(Max, trees[i]);
            Min = Math.min(Min, trees[i]);
        }

        //logic
        while (Min < Max) {
            long mid = (Min + Max) / 2;
            long sum = 0;
            for (long tree : trees) {
                long value = tree - mid;
                if (value > 0)
                    sum += value;
            }
            if (sum < M) {
                Max = mid;
            } else {
                Min = mid + 1;
            }
        }


        //output
        System.out.println(Min - 1);
    }
}
