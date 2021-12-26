import java.util.Scanner;

public class Num1629 {

    public static int A;
    public static int B;
    public static int C;
    public static long result;
    public static long rest = 1;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        A = Integer.parseInt(a[0]);
        B = Integer.parseInt(a[1]);
        C = Integer.parseInt(a[2]);

        //logic
        // A^2 % C   =   (A % C) * (A % C) % C
        result = A % C;
        while (B != 1) {
            // 23 % 2 -> 1   (2^2)11 * rest
            if (B % 2 == 1) {
                rest *= result;
                rest %= C;
            }
            B /= 2;

            // (A % C)^2
            result *= result;
            result %= C;
        }
        result *= rest;
        result %= C;

        //output
        System.out.println(result);
    }
}
