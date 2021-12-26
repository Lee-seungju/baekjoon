import java.util.Scanner;

public class Num2104 {

    public static int N;
    public static long Num[];
    public static long Max;

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        Num = new long[N];
        String[] a = scanner.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            Num[i] = Long.parseLong(a[i]);
        }

        //logic
        Max = Math.max(input(0, N-1), input1(0, N-1));

        //output
        System.out.println(Max);
    }

    public static long input(int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return Num[start] * Num[start];
        int mid = (start + end) / 2;
        long max = Math.max(input(start, mid), input(mid+1, end));

        int left = mid;
        int right = mid+1;
        long sum = Num[left] + Num[right];
        long min = Math.min(Num[left], Num[right]);
        max = Math.max(max, min * sum);
        while (left > start || right < end) {
            if (right < end && (left == start || Num[left-1] <  Num[right+1])) {
                right++;
                sum += Num[right];
                min = Math.min(min, Num[right]);
            } else {
                left--;
                sum += Num[left];
                min = Math.min(min, Num[left]);
            }
            max = Math.max(max, min * sum);
        }

        return max;
    }

    public static long input1(int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return Num[start] * Num[start];
        int mid = (start + end) / 2;
        long max = Math.max(input1(start, mid-1), input1(mid+1, end));

        long sum = Num[mid];
        long min = Num[mid];
        int left = mid;
        int right = mid;
        while (right - left < end - start) {
            long leftValue;
            long rightValue;

            if (left > start)
                leftValue = Num[left-1];
            else
                leftValue = -1;
            if (right < end)
                rightValue = Num[right+1];
            else
                rightValue = -1;

            if (leftValue > rightValue) {
                sum += leftValue;
                min = Math.min(min, leftValue);
                left--;
            } else {
                sum += rightValue;
                min = Math.min(min, rightValue);
                right++;
            }

            max = Math.max(max, sum * min);
        }
        return max;
    }

//    public static class Tree {
//
//        private int node=0;
//        private int nodeResult;
//        private Tree left=null;
//        private Tree right=null;
//
//        public Tree() {}
//
//        public void input(int start, int end) {
//            if (start == end) {
//                this.node = Num[start];
//            } else {
//                int mid = (start + end) / 2;
//                int min = Num[start];
//                for (int i=start+1; i<=end; i++) {
//                    min = Math.min(min, Num[i]);
//                }
//
//                this.left = new Tree();
//                this.left.input(start, mid);
//
//                this.right = new Tree();
//                this.right.input(mid + 1, end);
//
//                this.node = this.left.node + this.right.node;
//                this.nodeResult = this.node * min;
//
//            }
//        }
//
//        public void searchMax() {
//            if (this.left != null)
//                this.left.searchMax();
//            if (this.right != null)
//                this.right.searchMax();
//            Max = Math.max(Max, this.nodeResult);
//        }
//
//        public void printTree() {
//            System.out.println("this.node = " + this.node);
//            System.out.println("this.nodeResult = " + this.nodeResult);
//            if (this.left != null)
//                this.left.printTree();
//            if (this.right != null)
//                this.right.printTree();
//        }
//    }
}
