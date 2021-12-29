import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num1021 {

    public static int N;
    public static int M;
    public static int Num[];
    public static Queue<Integer> queue = new LinkedList<>();
    public static int count = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        Num = new int[M];
        a = scanner.nextLine().split(" ");
        for (int i=0; i<M; i++) {
            Num[i] = Integer.parseInt(a[i]);
        }
        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        //logic
        for (int i=0; i<M; i++) {
            int frontCount = 0, backCount = 0;
            while (Num[i] != queue.peek()) {
                queue.add(queue.poll());
                frontCount++;
            }
            queue.poll();
            backCount = N - frontCount;
            count += Math.min(backCount, frontCount);
            N--;
        }

        //output
        System.out.println(count);
    }
}
