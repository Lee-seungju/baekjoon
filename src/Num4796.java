import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num4796 {

    public static List<Integer> L = new ArrayList<>();
    public static List<Integer> P = new ArrayList<>();
    public static List<Integer> V = new ArrayList<>();
    public static int Line = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] n = scanner.nextLine().split(" ");
            if (n[0].equals("0") && n[1].equals("0") && n[2].equals("0"))
                break;
            L.add(Integer.parseInt(n[0]));
            P.add(Integer.parseInt(n[1]));
            V.add(Integer.parseInt(n[2]));
            Line++;
        }

        //logic
        for (int i=0; i<Line; i++) {
            int cal = V.get(i) % P.get(i);
            if (cal > L.get(i))
                cal = L.get(i);
            System.out.println("Case " + (i+1) + ": " + (V.get(i) / P.get(i) * L.get(i) + cal));
        }

        //output
    }
}
