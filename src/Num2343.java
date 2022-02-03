import java.util.Scanner;

public class Num2343 {

    public static int N;
    public static int M;
    public static int[] Num;
    public static int min;
    public static int max;
    public static int result;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        Num = new int[N];
        String[] b = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            Num[i] = Integer.parseInt(b[i]);
            max += Num[i];
            min = Math.max(min, Num[i]);
        }

        //logic
        int count = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            result = 0;
            count = 0;
            for (int i=0; i<N; i++) {
                if (sum + Num[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += Num[i];
            }
            if (sum != 0)
                count++;
            if (count > M)
                min = mid + 1;
            else
                max = mid - 1;
        }

        //output
        System.out.println(min);
    }
}
