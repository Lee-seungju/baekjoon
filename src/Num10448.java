import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num10448 {

    public static int T;
    public static int[] K;
    public static List<Integer> T_n;
    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        T = Integer.parseInt(scanner.nextLine());
        K = new int[T];
        for (int i=0; i<T; i++) {
            K[i] = Integer.parseInt(scanner.nextLine());
        }

        //logic
        Loop1:
        for (int i=0; i<T; i++) {
            T_n = new ArrayList<>();
            if (K[i] < 3 || K[i] > 1000) {
                System.out.println(0);
                continue Loop1;
            }
            int n=1;
            while (K[i] >= n*(n+1)/2) {
                T_n.add(n*(n+1)/2);
                n++;
            }
            //output
            for (int j1=0; j1<n-1; j1++) {
                for (int j2=0; j2<n-1; j2++) {
                    for (int j3=0; j3<n-1; j3++) {
                        if (T_n.get(j1) + T_n.get(j2) + T_n.get(j3) == K[i]) {
                            System.out.println(1);
                            continue Loop1;
                        }
                    }
                }
            }
            System.out.println(0);
        }
    }
}
