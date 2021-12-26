import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static long Num[];

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new long[N];
        for (int i=0; i<N; i++) {
            Num[i] = Long.parseLong(scanner.nextLine());
        }

        //logic

        //output
        System.out.println(input(0, N-1));

    }

    public static long input(int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return Num[start];
        int mid = (start + end) / 2;
        long max = Math.max(input(start, mid), input(mid+1, end));

        int left = mid;
        int right = mid+1;
        long min = Math.min(Num[left], Num[right]);
        long width = 2;
        long area = min * width;
        max = Math.max(max, area);
        while (left > start || right < end) {
            if (right < end && (left == start || Num[left-1] <  Num[right+1])) {
                right++;
                min = Math.min(min, Num[right]);
            } else {
                left--;
                min = Math.min(min, Num[left]);
            }
            width++;
            max = Math.max(max, min * width);
        }

        return max;
    }
}