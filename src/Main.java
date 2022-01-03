import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static int map[][];
    public static int L;
    public static String order[];

    public static Deque<Integer> col = new ArrayDeque<>();
    public static Deque<Integer> raw = new ArrayDeque<>();
    public static int count = 0;

    public static int direction = 0;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        for (int i=0; i<N+2; i++) {
            for (int j=0; j<N+2; j++) {
                if (i==0 || j==0 || i==N+1 || j==N+1)
                    map[i][j] = 1;
            }
        }
        for (int i=0; i<K; i++) {
            String[] a = br.readLine().split(" ");
            map[Integer.parseInt(a[0])][Integer.parseInt(a[1])] = 2;
        }

        L = Integer.parseInt(br.readLine());

        order = new String[L];
        for (int i=0; i<L; i++) {
            order[i] = br.readLine();
        }

        //logic
        col.addLast(1);
        raw.addLast(1);
        int i=0;
        String[] a = order[i].split(" ");
        while (true) {
            int b_col = col.getLast();
            int b_raw = raw.getLast();
            map[b_col][b_raw] = 3;
            if (count == Integer.parseInt(a[0])) {
                if (a[1].equals("L")) {
                    if (direction == 0)
                        direction = 3;
                    else
                        direction--;
                } else if (a[1].equals("D")) {
                    if (direction == 3)
                        direction = 0;
                    else
                        direction++;
                }
                i++;
                if (i < L)
                    a = order[i].split(" ");
            }
            int n_col=0;
            int n_raw=0;
            if (direction == 0)
                n_raw++;
            else if (direction == 1)
                n_col++;
            else if (direction == 2)
                n_raw--;
            else if (direction == 3)
                n_col--;

            count++;

            if (map[b_col + n_col][b_raw + n_raw] == 0) {
                map[col.pollFirst()][raw.pollFirst()] = 0;
                col.addLast(b_col + n_col);
                raw.addLast(b_raw + n_raw);
                map[b_col + n_col][b_raw + n_raw] = 3;
            } else if (map[b_col + n_col][b_raw + n_raw] == 2) {
                col.addLast(b_col + n_col);
                raw.addLast(b_raw + n_raw);
                map[b_col + n_col][b_raw + n_raw] = 3;
            } else if (map[b_col + n_col][b_raw + n_raw] == 1 || map[b_col + n_col][b_raw + n_raw] == 3) {
                break;
            }
        }


        //output
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}