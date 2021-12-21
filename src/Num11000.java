import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Num11000 {

    public static int N;
    public static int[][] startEnd;
    public static PriorityQueue<Integer> q = new PriorityQueue<>();

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
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
//        for (int[] b : startEnd) {
//            System.out.println(b[0] + ", " + b[1]);
//        }
        q.offer(startEnd[0][1]);

        //logic
        for (int i=1; i<N; i++) {
            if (q.peek() <= startEnd[i][0])
                q.poll();
            q.offer(startEnd[i][1]);
        }
        //output
        System.out.println(q.size());
    }
}
