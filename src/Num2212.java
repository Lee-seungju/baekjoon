import java.util.*;

public class Num2212 {

    public static int N;
    public static int K;
    public static int[] Num;
    public static Integer[] diff;
    public static int result=0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        K = Integer.parseInt(scanner.nextLine());
        if (N <= K) {
            System.out.println(0);
            return;
        }
        Num = new int[N];
        diff = new Integer[N-1];
        String[] n = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++)
            Num[i] = Integer.parseInt(n[i]);

        Arrays.sort(Num);

        for (int i=0; i<N-1; i++)
            diff[i] = (Math.abs(Num[i] - Num[i+1]));

        Arrays.sort(diff, Comparator.reverseOrder());

        //logic
        for (int i=1; i<K; i++) {
            diff = remove(diff);
        }
//        for (Integer a : diff)
//            System.out.print(a + " ");
//        System.out.println();

        for (int i=0; i<diff.length; i++)
            result += diff[i];

        //output
        System.out.println(result);
    }

    public static Integer[] remove(Integer[] d) {
        Integer[] a = new Integer[d.length-1];
        for (int i=1; i<d.length; i++) {
            a[i-1] = d[i];
        }
        return a;
    }
}
