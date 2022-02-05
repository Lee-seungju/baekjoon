import java.util.Scanner;

public class Num15732 {

    public static long N;
    public static int K;
    public static long D;
    public static Pair[] pairs;
    public static long max;
    public static long min = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        K = scanner.nextInt();
        D = scanner.nextLong();
        pairs = new Pair[K];
        max = N;
        for (int i=0; i<K; i++) {
            pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        }

        //logic
        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i=0; i<K; i++) {
                if (mid >= pairs[i].A) {
                    if (mid < pairs[i].B)
                        count += (mid - pairs[i].A) / pairs[i].C + 1;
                    else
                        count += (pairs[i].B - pairs[i].A) / pairs[i].C + 1;
                }
            }
            if (count >= D) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min);
    }

    public static class Pair {
        int A;
        int B;
        int C;
        public Pair(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
