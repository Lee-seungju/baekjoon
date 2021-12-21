import java.util.Scanner;

public class Num1700 {

    public static int N;
    public static int K;
    public static int[] Num;
    public static int count = 0;
    public static int[] plug;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        K = Integer.parseInt(a[1]);
        Num = new int[K];
        plug = new int[N];
        a = scanner.nextLine().split(" ");
        for (int i=0; i<K; i++) {
            Num[i] = Integer.parseInt(a[i]);
        }

        //logic
        Loop1:
        for (int i=0; i<K; i++) {
            for (int j=0; j<N; j++) {
                if (plug[j] == Num[i])
                    continue Loop1;
            }
            for (int j=0; j<N; j++) {
                if (plug[j] == 0) {
                    plug[j] = Num[i];
                    continue Loop1;
                }
            }
            int idx = -1, deviceIdx = -1;
            for (int j=0; j<N; j++) {
                int lastIdx = 0;
                for (int k=i+1; k<K; k++) {
                    if (plug[j] == Num[k])
                        break;
                    lastIdx++;
                }
                if (lastIdx > deviceIdx) {
                    idx = j;
                    deviceIdx = lastIdx;
                }
            }
            count++;
            plug[idx] = Num[i];
        }

        //output
        System.out.println(count);
    }
}
