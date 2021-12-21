import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num2331 {

    public static void main(String[] args) {
        //input
        List<Integer> num = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int P = scanner.nextInt();
        num.add(A);

        //logic
        int i=0;
        int result = 0;
        Loop1:
        while (true) {
            int copy = num.get(i);
            int sum = 0;
            while (copy != 0) {
                sum += Math.pow(copy % 10, P);
                copy /= 10;
            }
            for (int j=0; j<num.size(); j++) {
                if (num.get(j) == sum) {
                    result = j;
                    break Loop1;
                }
            }
            num.add(sum);
            i++;
        }

        //output
        System.out.println(result);
    }
}
