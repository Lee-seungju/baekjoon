import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Num5397 {

    public static int L;
    public static String[] Password;
    public static Deque<String> leftDeque = new ArrayDeque<>();
    public static Deque<String> rightDeque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //input
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        L = Integer.parseInt(br.readLine());
        Password = new String[L];

        for (int i=0; i<L; i++) {
            Password[i] = br.readLine();
        }


        //logic
        for (int i=0; i<L; i++) {
            String[] order = Password[i].split("");

            for (int j=0; j<order.length; j++) {
                char c = order[j].charAt(0);
                switch (c) {
                    case '<':
                        if (!leftDeque.isEmpty())
                            rightDeque.addFirst(leftDeque.pollLast());
                        break;
                    case '>':
                        if (!rightDeque.isEmpty())
                            leftDeque.addLast(rightDeque.pollFirst());
                        break;
                    case '-':
                        if (!leftDeque.isEmpty())
                            leftDeque.removeLast();
                        break;
                    default:
                        leftDeque.addLast(String.valueOf(c));
                        break;
                }
            }

            //output
            while (!leftDeque.isEmpty())
                sb.append(leftDeque.pollFirst());
            while (!rightDeque.isEmpty())
                sb.append(rightDeque.pollFirst());
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
