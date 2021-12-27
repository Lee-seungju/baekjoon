import java.util.Scanner;

public class Num1780 {

    public static int N;
    public static int Num[][];
    public static int firstNum=0;
    public static int secondNum=0;
    public static int thirdNum=0;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] a = scanner.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                Num[i][j] = Integer.parseInt(a[j]);
            }
        }

        //logic
        input(0, 0, N);

        //output
        System.out.println(firstNum);
        System.out.println(secondNum);
        System.out.println(thirdNum);
    }

    public static void input(int startHeight,int startWidth, int size) {
        int num = Num[startHeight][startWidth];
        for (int i=startHeight; i<startHeight+size; i++) {
            for (int j=startWidth; j<startWidth+size; j++) {
                if (Num[i][j] != num) {
                    if (size == 3) {
                        for (int k=0; k<3; k++) {
                            for (int t=0; t<3; t++) {
                                if (Num[startHeight + k][startWidth + t] == -1)
                                    firstNum++;
                                else if (Num[startHeight + k][startWidth + t] == 0)
                                    secondNum++;
                                else if (Num[startHeight + k][startWidth + t] == 1)
                                    thirdNum++;
                            }
                        }
                        return;
                    }
                    for (int k=0; k<3; k++) {
                        for (int t=0; t<3; t++) {
                            input(startHeight + k * (size/3),
                                    startWidth + t * (size/3) , size/3);
                        }
                    }
                    return;
                }
            }
        }
        if (num == -1)
            firstNum++;
        else if (num == 0)
            secondNum++;
        else if (num == 1)
            thirdNum++;
    }
}
