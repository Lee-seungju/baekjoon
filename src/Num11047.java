import java.util.Scanner;

public class Num11047 {

    public static int N;
    public static int K;
    public static int[] Num;
    public static int count=2147483647;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        K = Integer.parseInt(firstLine[1]);
        Num = new int[N];
        for(int i=0; i<N; i++) {
            Num[i] = Integer.parseInt(scanner.nextLine());
        }

        //logic
        for (int i=N-1; i>=0; i--) {
            int min = 0;
            int copy_K = K;
            for (int j=i; j>=0; j--) {
                min += copy_K / Num[j];
                copy_K %= Num[j];
            }
            if (min != 0 && min < count)
                count = min;
        }

        //output
        System.out.println(count);
    }
}
