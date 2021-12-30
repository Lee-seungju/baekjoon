import java.util.*;

public class Num2346 {

    public static int N;
    public static Deque<Integer> deque = new ArrayDeque<>();
    public static int Num[];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        String[] a = scanner.nextLine().split(" ");
        Num = new int[N + 1];
        for (int i=1; i<=N; i++) {
            Num[i] = Integer.parseInt(a[i-1]);
            deque.addLast(i);
        }

        //logic
        while(true) {
            if (deque.peek() == 1)
                System.out.print(deque.peek());
            else
                System.out.print(" " + deque.peek());
            int paperNum = Num[deque.pollFirst()];
            if (deque.isEmpty())
                break;
            N--;

            if (paperNum > 0) {
                for (int i = 0; i < paperNum - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i=paperNum; i < 0; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
    }
}
