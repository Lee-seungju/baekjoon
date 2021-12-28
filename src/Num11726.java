import java.util.Scanner;

public class Num11726 {

    public static int N;
    public static int Num[];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new int[N+2];

        //logic
        Num[1] = 1;
        Num[2] = 2;
        for (int i=3; i<=N; i++) {
            Num[i] = (Num[i-1] + Num[i-2]) % 10007;
        }

        //output
        System.out.println(Num[N]);
    }
}
