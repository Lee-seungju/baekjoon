import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static String orders[];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        orders = new String[N];
        for (int i=0; i<N; i++) {
            orders[i] = br.readLine();
        }

        //logic
        Quu quu = new Quu();
        for (String order : orders) {
            switch (order) {
                case "pop":
                    bw.write(quu.pop() + "\n");
                    break;
                case  "size":
                    bw.write((quu.size()) + "\n");
                    break;
                case "empty":
                    bw.write((quu.empty()) + "\n");
                    break;
                case "front":
                    bw.write((quu.front()) + "\n");
                    break;
                case "back":
                    bw.write((quu.back()) + "\n");
                    break;
                default:
                    int num = Integer.parseInt(order.split(" ")[1]);
                    quu.push(num);
            }
        }

        bw.flush();
        bw.close();
    }

    static class Quu {
        private int size = 0;
        private int stack[] = new int[30001];

        public int pop() {
            if (size == 0)
                return -1;
            return stack[--size];
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0)
                return 1;
            return 0;
        }

        public int front() {
            if (size == 0)
                return -1;
            return stack[size - 1];
        }

        public int back() {
            if (size == 0)
                return -1;
            return stack[0];
        }

        public void push(int num) {
            for (int i=0; i<size; i++) {
                stack[i + 1] = stack[i];
            }
            stack[0] = num;
            size++;
        }
    }
}