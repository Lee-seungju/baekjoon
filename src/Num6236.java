import java.util.Scanner;

public class Num6236 {

    public static int N;
    public static int M;
    public static int[] Num;
    public static int min;
    public static int max;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        Num = new int[N];
        for (int i=0; i<N; i++) {
            Num[i] = Integer.parseInt(scanner.nextLine());
            max += Num[i];
            min = Math.max(Num[i], min);
        }

        //logic
        while (min < max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int count = 0;
            for (int n : Num) {
                if (sum < n) {
                    count++;
                    sum = mid;
                }
                sum -= n;
            }
            if (count > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        //output
        System.out.println(min);
    }
}
