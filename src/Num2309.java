import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Num2309 {

    public static void main(String[] args) throws IOException {
        //input
        int sum = 0;
        List<Integer> num = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<9; i++) {
            int price = scanner.nextInt();
            num.add(price);
            sum += price;
        }

        //logic
        Loop1:
        for (int i=0; i<num.size(); i++) {
            for (int j=i+1; j<num.size(); j++) {
                if (num.get(i) + num.get(j) == sum - 100) {
                    num.remove(i);
                    num.remove(j - 1);
                    break Loop1;
                }
            }
        }
        Collections.sort(num);

        //output
        for (int a : num) {
            System.out.println(a);
        }
    }
}