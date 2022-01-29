import java.io.*;

public class Num5639 {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Tree tree = new Tree(Integer.parseInt(br.readLine()));


        //logic
        String str = "";
        while ((str = br.readLine()) != null) {
            if (str.equals(""))
                break;
            tree.insert(Integer.parseInt(str));
        }

        //output
        tree.printAll(bw);
        bw.flush();
        bw.close();
    }

    static class Tree {
        private Tree leftTree = null;
        private Tree rightTree = null;
        private int node;

        Tree(int value) {
            node = value;
        }

        void insert(int value) {
            if (value < node) {
                if (leftTree == null)
                    leftTree = new Tree(value);
                else
                    leftTree.insert(value);
            } else {
                if (rightTree == null)
                    rightTree = new Tree(value);
                else
                    rightTree.insert(value);
            }
        }
        BufferedWriter printAll(BufferedWriter bw) throws IOException {
            if (leftTree != null)
                leftTree.printAll(bw);
            if (rightTree != null)
                rightTree.printAll(bw);
            bw.write(node + "\n");
            return bw;
        }
    }
}
