import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static int N;
    public static Deque<Integer[]> Num = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            String[] str = br.readLine().split(" ");
            Integer[] n = new Integer[2];
            n[0] = Integer.parseInt(str[0]);
            n[1] = Integer.parseInt(str[1]);
            Num.add(n);
        }


        //logic
        Tree tree = new Tree(1, new Tree(0, null));
        while (Num.isEmpty() == false) {
            int firstNum = Num.peek()[0];
            int secondNum = Num.peek()[1];
            if (findAndInsert(firstNum, secondNum, tree) == false)
                Num.addLast(Num.pop());
            else
                Num.pop();
        }

        //output
        for (int i = 2; i <= N; i++) {
            bw.write(findTree(i, tree) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean findAndInsert(int first, int second, Tree root) {
        if (root.node == first) {
            root.insert(second);
            return true;
        } else if (root.node == second) {
            root.insert(first);
            return true;
        }
        for (Tree tree : root.jaSik) {
            if (findAndInsert(first, second, tree) == true)
                return true;
        }
        return false;
    }

    public static int findTree(int node, Tree tree) {
        for (Tree tree1 : tree.jaSik) {
            if (tree1.node == node)
                return tree1.parent.node;
            int tree2 = findTree(node, tree1);
            if (tree2 != -1)
                return tree2;
        }
        return -1;
    }

    static class Tree {
        private List<Tree> jaSik = new ArrayList<>();
        private Tree parent;
        private Integer node;

        Tree(int value, Tree parentNode) {
            node = value;
            parent = parentNode;
        }

        Tree insert(int value) {
            Tree newTree = new Tree(value, this);
            jaSik.add(newTree);
            return newTree;
        }

        void printAll() {
            System.out.println(node);
            for (Tree tree : jaSik) {
                tree.printAll();
            }
        }
    }
}