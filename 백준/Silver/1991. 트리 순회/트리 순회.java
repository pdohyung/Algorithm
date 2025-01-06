import java.io.*;
import java.util.*;

class Node {
    char left;
    char right;

    public Node(char left, char right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    private static Map<Character, Node> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();


        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");

            char root = info[0].charAt(0);
            char left = info[1].charAt(0);
            char right = info[2].charAt(0);

            tree.put(root, new Node(left, right));
        }

        preOrder('A');
        System.out.println();

        inOrder('A');
        System.out.println();

        postOrder('A');
        System.out.println();
    }

    private static void preOrder(char current) {
        if (current == '.') return;

        System.out.print(current);
        preOrder(tree.get(current).left);
        preOrder(tree.get(current).right);
    }

    private static void inOrder(char current) {
        if (current == '.') return;

        inOrder(tree.get(current).left);
        System.out.print(current);
        inOrder(tree.get(current).right);
    }

    private static void postOrder(char current) {
        if (current == '.') return;

        postOrder(tree.get(current).left);
        postOrder(tree.get(current).right);
        System.out.print(current);
    }
}
