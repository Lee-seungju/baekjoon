import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

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
        result = A%C;
        while (B != 1) {
            if (B % 2 == 1) {
                rest *= result;
                rest %= C;
            }
            B /= 2;

            result *= result;
            result %= C;
        }
        result *= rest;
        result %= C;

        //output
        System.out.println(result);
    }
}