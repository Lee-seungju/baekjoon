import java.io.*;

public class Num9934 {

    public static int l;
    public static int[] Num;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        l = Integer.parseInt(br.readLine());
        Num = new int[(int)Math.pow(2, l) - 1];
        String[] str = br.readLine().split(" ");
        for (int i=0; i<(int)Math.pow(2, l) - 1; i++) {
            Num[i] = Integer.parseInt(str[i]);
        }

        //logic
        Tree tree = new Tree();
        insert(0, (int)Math.pow(2, l) - 2, tree, 1);

        //output
        for (int i=1; i<=l; i++) {
            tree.printLevel(i, bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void insert(int first, int end, Tree tree, int level) {
        int mid = (first + end) / 2;
        tree.node = Num[mid];
        tree.level = level;
        if (level == l)
            return;
        tree.leftTree = new Tree();
        tree.rightTree = new Tree();
        insert(first, mid - 1, tree.leftTree, level + 1);
        insert(mid + 1, end, tree.rightTree, level + 1);
    }

    static class Tree {
        private int level = 0;
        private Integer node = null;
        private Tree leftTree = null;
        private Tree rightTree = null;

        Tree () {
        }

        void printAll() {
            if (leftTree != null)
                leftTree.printAll();
            System.out.print(" "+node);
            if (rightTree != null)
                rightTree.printAll();
        }

        BufferedWriter printLevel(int lev, BufferedWriter bw) throws IOException {
            if (level == lev) {
                bw.write(node + " ");
                return bw;
            }
            else if (level < lev) {
                if (leftTree != null)
                    leftTree.printLevel(lev, bw);
                if (rightTree != null)
                    rightTree.printLevel(lev, bw);
            }
            return bw;
        }
    }
}
