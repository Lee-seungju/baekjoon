
import java.util.Scanner;

public class Num2231 {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //logic
        for (int i=1; i<num; i++) {
            int sum = 0;
            int copy = i;
            while (copy != 0) {
                sum += copy % 10;
                copy /= 10;
            }
            if (sum + i == num) {
                System.out.println(i);
                return ;
            }
        }

        //output
        System.out.println(0);
    }
}


