import javax.print.attribute.standard.PresentationDirection;
import java.util.Scanner;

public class Num2339 {

    public static int N;
    public static int Num[][];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] a = scanner.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                Num[i][j] = Integer.parseInt(a[j]);
            }
        }

        //logic
        int answer = input(0, N, 0, N, -1);

        //output
        if (answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static int input(int startHeight, int endHeight, int startWidth, int endWidth, int cut) {
        int answer = 0;
        int voSuck = 0;
        int bollSoon = 0;
        for (int i=startHeight; i < endHeight; i++) {
            for (int j=startWidth; j < endWidth; j++) {
                if (Num[i][j] == 1)
                    bollSoon++;
                else if (Num[i][j] == 2)
                    voSuck++;
            }
        }
        if (voSuck == 0 || (voSuck == 1 && bollSoon >= 1) || (voSuck >=2 && bollSoon == 0))
            return 0;
        else if (voSuck == 1 && bollSoon == 0)
            return 1;
        else {
            for (int i=startHeight; i < endHeight; i++) {
                for (int j=startWidth; j < endWidth; j++) {
                    if (Num[i][j] == 1) {
                        if (cut != 0) {
                            boolean signal = true;
                            for (int k = startWidth; k < endWidth; k++) {
                                if (Num[i][k] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal == true) {
                                int first = input(startHeight, i, startWidth, endWidth, 0);
                                int second = input(i + 1, endHeight, startWidth, endWidth, 0);
                                answer += first * second;
                            }
                        }
                        if (cut != 1) {
                            boolean signal = true;
                            signal = true;
                            for (int k = startHeight; k < endHeight; k++) {
                                if (Num[k][j] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal == true) {
                                int first = input(startHeight, endHeight, startWidth, j, 1);
                                int second = input(startHeight, endHeight, j + 1, endWidth, 1);
                                answer += first * second;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
