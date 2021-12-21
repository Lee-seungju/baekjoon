import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num2503 {

    public static int N;
    public static int[] num;
    public static int[] S;
    public static int[] B;
    public static int result = 0;
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        num = new int[N];
        S = new int[N];
        B = new int[N];
        for (int i=0; i<N; i++) {
            String[] message = scanner.nextLine().split(" ");
            num[i] = Integer.parseInt(message[0]);
            S[i] = Integer.parseInt(message[1]);
            B[i] = Integer.parseInt(message[2]);
        }

        //logic
        for (int i=123; i<789; i++) {
            int count = 0;
            if (i/100 == (i%100)/10 || (i%100)/10 == i%10 || i/100 == i%10)
                continue ;
            for (int j=0; j<N; j++) {
                int ball = 0;
                int strike = 0;
                if (i/100 == num[j]/100)
                    strike++;
                else if (i/100 == (num[j]%100)/10 || i/100 == num[j]%10)
                    ball++;
                if ((i%100)/10 == (num[j]%100)/10)
                    strike++;
                else if ((i%100)/10 == num[j]/100 || (i%100)/10 == num[j]%10)
                    ball++;
                if (i%10 == num[j]%10)
                    strike++;
                else if (i%10 == num[j]/100 || i%10 == (num[j]%100)/10)
                    ball++;
                if (strike == S[j] && ball == B[j])
                    count++;
            }
            if (count == N)
                result++;
        }

        //output
        System.out.println(result);
    }
}
