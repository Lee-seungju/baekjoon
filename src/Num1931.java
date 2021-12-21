import java.util.*;

public class Num1931 {

    public static int N;
    public static int[][] startEnd;
    public static int count = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        startEnd = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] n = scanner.nextLine().split(" ");
            startEnd[i][0] = Integer.parseInt(n[0]);
            startEnd[i][1] = Integer.parseInt(n[1]);
        }
        Arrays.sort(startEnd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int o2[]) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        //logic
        int prevTime = 0;
        for (int i=0; i<N; i++) {
            if (startEnd[i][0] >= prevTime) {
                prevTime = startEnd[i][1];
                count++;
            }
        }

        //output
        System.out.println(count);
    }
}
