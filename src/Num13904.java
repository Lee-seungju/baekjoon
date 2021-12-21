import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Num13904 {

    public static int N;
    public static int[][] d;
    public static int[] dayList;
    public static int result = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        d = new int[N][2];
        dayList = new int[N];
        for (int i=0; i<N; i++) {
            String[] a = scanner.nextLine().split(" ");
            d[i][0] = Integer.parseInt(a[0]);
            d[i][1] = Integer.parseInt(a[1]);
        }

        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1])
                    return o2[0]-o1[0];
                return o2[1]-o1[1];
            }
        });

        //logic
        for (int i=0; i<N; i++) {
            int j=0;
            while (j<N) {
                if (dayList[j] == d[i][0]) {
                    if (d[i][0] == 0)
                        break;
                    d[i][0]--;
                    j=0;
                    continue;
                }
                j++;
            }
            if (d[i][0] == 0)
                continue;
            for (int k=0; k<N; k++) {
                if (dayList[k] == 0) {
                    dayList[k] = d[i][0];
                    result += d[i][1];
                    break;
                }
            }
        }

        //output
        System.out.println(result);
    }
}
