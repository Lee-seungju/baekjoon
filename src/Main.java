import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static int Num[][];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] a = scanner.nextLine().split("");
            for (int j=0; j<N; j++) {
                Num[i][j] = Integer.parseInt(a[j]);
            }
        }


        //logic

        //output
        input(0, 0, N);
    }

    public static void input(int startHeight,int startWidth, int size) {
        int num = Num[startHeight][startWidth];
        for (int i=startHeight; i<startHeight+size; i++) {
            for (int j=startWidth; j<startWidth+size; j++) {
                if (Num[i][j] != num) {
                    if (size == 2) {
                        System.out.print("(");
                        for (int k = startHeight; k < startHeight + 2; k++) {
                            for (int t = startWidth; t < startWidth + 2; t++) {
                                System.out.print(Num[k][t]);
                            }
                        }
                        System.out.print(")");
                        return;
                    }
                    System.out.print("(");
                    for (int k=0; k<2; k++) {
                        for (int t=0; t<2; t++) {
                            input(startHeight + k * (size/2),
                                    startWidth + t * (size/2) , size/2);
                        }
                    }
                    System.out.print(")");
                    return;
                }
            }
        }
        System.out.print(num);
    }
}