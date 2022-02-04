import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Num16434 {

    public static int N;
    public static long HAttack;
    public static Pair[] tah;
    public static long min = 1;
    public static long max = (long)Math.pow(10, 18);

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        HAttack = Integer.parseInt(a[1]);
        tah = new Pair[N];
        for (int i=0; i<N; i++) {
            String[] b = br.readLine().split(" ");
            tah[i] = new Pair(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
        }

        //logic
        while (min < max) {
            long mid = (min + max) / 2;

            if (check(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        //output
        System.out.println(min);
    }

    public static boolean check(long mid) {
        long hp = mid;
        long atk = HAttack;
        for (int i=0; i<N; i++) {
            if (tah[i].t == 2) {
                if (hp + tah[i].h > mid) {
                    hp = mid;
                } else
                    hp += tah[i].h;
                atk += tah[i].a;
            } else {
                long cnt = tah[i].h / atk;
                if (tah[i].h % atk == 0)
                    cnt--;
                hp -= cnt * tah[i].a;
                if (hp <= 0)
                    return false;
            }
        }
        if (hp <= 0)
            return false;
        return true;
    }

    public static class Pair {
        int t;
        int a;
        int h;

        public Pair(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
