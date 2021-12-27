import java.util.Scanner;

public class Num1074 {

    public static int N;
    public static int r;
    public static int c;
    public static int index = 0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        N = Integer.parseInt(a[0]);
        r = Integer.parseInt(a[1]);
        c = Integer.parseInt(a[2]);


        //logic

        //output
        input(0, 0, (int)Math.pow(2, N));
    }

    public static void input(int startHeight,int startWidth, int size) {
        if (size == 2) {
            for (int i=0; i<2; i++) {
                for (int j=0; j<2; j++) {
                    if (startHeight + i == r && startWidth + j == c) {
                        System.out.println(index);
                        return;
                    }
                    index++;
                }
            }
            return;
        }
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                if (startHeight + i * (size/2) <= r && r <= startHeight + (i+1) * (size/2)  &&
                        startWidth + j * (size/2) <= c && c <= startWidth + (j+1) * (size/2))
                    input(startHeight + i * (size/2), startWidth + j * (size/2), size/2);
                else
                    index += (size/2) * (size/2);
            }
        }
    }
}
