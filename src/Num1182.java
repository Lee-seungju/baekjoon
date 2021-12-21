
import java.util.Arrays;
import java.util.Scanner;

public class Num1182 {

    public static int N;
    public static int S;
    public static int[] num;

    public static int count = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] NS = scanner.nextLine().split(" ");
        N = Integer.parseInt(NS[0]);
        S = Integer.parseInt(NS[1]);
        num = new int[N];

        String[] num_s = scanner.nextLine().split(" ");

        for (int i=0; i<N; i++) {
            num[i] = Integer.parseInt(num_s[i]);
        }

        //logic
        caculate(0, 0);

        //output
        System.out.println(count);
    }

    public static void caculate(int i, int sum) {
        if (i == N)
            return;
        if (sum + num[i] == S)
            count++;

        caculate(i+1, sum);
        caculate(i+1, sum + num[i]);
    }
}
