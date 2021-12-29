import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        K = Integer.parseInt(a[1]);
        for (int i=1; i<=N; i++)
            queue.add(i);

        //logic, output
        System.out.print("<");
        while (!queue.isEmpty()) {
            for (int i=1; i<=K - 1; i++) {
                queue.add(queue.poll());
            }
            System.out.print(queue.poll());
            if (!queue.isEmpty())
                System.out.print(", ");
        }
        System.out.println(">");
    }
}