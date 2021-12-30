import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Num2840 {

    public static int N;
    public static int K;
    public static int S1[];
    public static String S2[];
    public static Deque<String> deque = new ArrayDeque<>();

    public static int[] alpha = new int[27];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        K = Integer.parseInt(a[1]);
        S1 = new int[K];
        S2 = new String[K];
        for (int i=0; i<K; i++) {
            a = scanner.nextLine().split(" ");
            S1[i] = Integer.parseInt(a[0]);
            S2[i] = a[1];
        }
        for (int i=0; i<N; i++) {
            deque.addLast("?");
        }

        //logic
        for (int i=0; i<K; i++) {
            for (int j=0; j<S1[i]; j++) {
                deque.addLast(deque.pollFirst());
            }
            if (!deque.peek().equals("?") && !deque.peek().equals(S2[i]) ||
                    deque.peek().equals("?") && alpha[S2[i].charAt(0)-'A'] == 1) {
                System.out.println("!");
                return;
            } else {
                deque.pollFirst();
                deque.addFirst(S2[i]);
                alpha[S2[i].charAt(0)-'A'] = 1;
            }
        }
        deque.addLast(deque.pollFirst());

        //output
        for (int i=0; i<N; i++) {
            System.out.print(deque.pollLast());
        }
        System.out.println();
    }
}
