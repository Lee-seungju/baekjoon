import java.util.*;

public class Num1449 {

    public static int N;
    public static int L;
    public static List<Integer> Num = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        L = Integer.parseInt(firstLine[1]);
        String[] secondLine = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            Num.add(Integer.parseInt(secondLine[i]));
        }

        //logic
        Collections.sort(Num);
        int lastIndex = Num.size()-1;
        int i=0;
        while (i<N) {
            double n = Num.get(i) - 0.5;
            while (i < N && n+L > Num.get(i))
                i++;
            count++;
        }

        //output
        System.out.println(count);
    }
}
