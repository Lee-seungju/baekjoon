import java.io.*;

public class Num1991 {

    public static int N;
    public static String[] order;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        order = new String[N];
        for (int i=0; i<N; i++) {
            order[i] = br.readLine();
        }
        //logic
        Tree tree = new Tree("A");
        for (int i=0; i<N; i++) {
            String[] value = order[i].split(" ");
            Tree findTree = findTree(value[0], tree);
            findTree.insert(value[1], value[2]);
        }


        //output
        tree.printFirst();
        System.out.println();
        tree.printSecond();
        System.out.println();
        tree.printThird();
    }

    public static Tree findTree(String node, Tree root) {
        Tree left = null;
        Tree right = null;
        if (root.node.equals(node))
            return root;
        if (root.leftTree != null)
            left = findTree(node, root.leftTree);
        if (root.rightTree != null)
            right = findTree(node, root.rightTree);
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    static class Tree {
        private Tree leftTree = null;
        private Tree rightTree = null;
        private String node = null;

        Tree(String value) {
            node = value;
        }

        void insert(String left, String right) {
            if (!left.equals("."))
                this.leftTree = new Tree(left);
            if (!right.equals("."))
                this.rightTree = new Tree(right);
        }

        void printFirst() {
            System.out.print(node);
            if (leftTree != null)
                leftTree.printFirst();
            if (rightTree != null)
                rightTree.printFirst();
        }

        void printSecond() {
            if (leftTree != null)
                leftTree.printSecond();
            System.out.print(node);
            if (rightTree != null)
                rightTree.printSecond();
        }

        void printThird() {
            if (leftTree != null)
                leftTree.printThird();
            if (rightTree != null)
                rightTree.printThird();
            System.out.print(node);
        }
    }
}
