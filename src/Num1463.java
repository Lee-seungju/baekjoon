import java.util.Scanner;

public class Num1463 {

    public static int N;
    public static int Num[];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new int[N + 1];

        //logic
        Num[1] = 0;
        for (int i=2; i<=N; i++) {
            Num[i] = Num[i-1] + 1;
            if (i % 2 == 0)
                Num[i] = Math.min(Num[i], Num[i/2] + 1);
            if (i % 3 == 0)
                Num[i] = Math.min(Num[i], Num[i/3] + 1);
        }

        //output
        System.out.println(Num[N]);
    }
}
