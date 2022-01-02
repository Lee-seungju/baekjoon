import java.io.*;
import java.util.*;

public class Num1406 {

    public static String N;
    public static int M;
    public static Deque<String> leftDeque = new ArrayDeque<>();
    public static Deque<String> rightDeque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //input
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = br.readLine();
        M = Integer.parseInt(br.readLine());

        String[] ab = N.split("");
        for (String s : ab) {
            leftDeque.addLast(s);
        }

        //logic
        for (int i=0; i<M; i++) {
            String a = br.readLine();
            char c = a.charAt(0);
            switch (c) {
                case 'L':
                    if (!leftDeque.isEmpty())
                        rightDeque.addFirst(leftDeque.pollLast());
                    break;
                case 'D':
                    if (!rightDeque.isEmpty())
                        leftDeque.addLast(rightDeque.pollFirst());
                    break;
                case 'B':
                    if (!leftDeque.isEmpty())
                        leftDeque.removeLast();
                    break;
                case 'P':
                    char t = a.charAt(2);
                    leftDeque.addLast(String.valueOf(t));
                    break;
                default:
                    break;
            }
        }

        //output
        while (!leftDeque.isEmpty())
            sb.append(leftDeque.pollFirst());
        while (!rightDeque.isEmpty())
            sb.append(rightDeque.pollFirst());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
