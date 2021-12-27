import java.util.Scanner;

public class Num2447 {

    public static int N;
    public static String[] Num;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new String[N];
        for (int i=0; i<N; i++)
            Num[i] = "";

        //logic
        input(0, 0, N);

        //output
        for (int i=0; i<N; i++) {
            System.out.println(Num[i]);
        }
    }

    public static void input(int startHeight,int startWidth, int size) {
        if (size == 3) {
            Num[startHeight] += "***";
            Num[startHeight + 1] += "* *";
            Num[startHeight + 2] += "***";
            return;
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i != 1 || j != 1)
                    input(startHeight + i * (size/3), startWidth + j * (size/3), size/3);
                else {
                    for (int k=0; k<size/3; k++) {
                        for (int t=0; t<size/3; t++) {
                            Num[startHeight + k + i * (size/3)] += " ";
                        }
                    }
                }
            }
        }
    }
}
