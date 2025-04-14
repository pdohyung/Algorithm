import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;
    static List<Node> zeros;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        zeros = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                if (chars[j] == '0') zeros.add(new Node(i, j));
                board[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == zeros.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == 0) return;
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

            System.exit(0);
        }

        Node zero = zeros.get(depth);
        int x = zero.x;
        int y = zero.y;

        for (int i = 1; i <= 9; i++) {
            if (board[x][y] == 0 && checkC(i, y) && checkR(i, x) && checkB(i, x, y)) {
                board[x][y] = i;
                dfs(depth + 1);
                board[x][y] = 0;
            }
        }

    }

    private static boolean checkC(int i, int y) {
        for (int j = 0; j < 9; j++) {
            if (board[j][y] == i) return false;
        }

        return true;
    }

    private static boolean checkR(int i, int x) {
        for (int j = 0; j < 9; j++) {
            if (board[x][j] == i) return false;
        }

        return true;
    }

    private static boolean checkB(int i, int x, int y) {
        int x1 = (x / 3) * 3;
        int x2 = (x / 3) * 3 + 2;
        int y1 = (y / 3) * 3;
        int y2 = (y / 3) * 3 + 2;

        for (int j = x1; j <= x2; j++) {
            for (int k = y1; k <= y2; k++) {
                if (board[j][k] == i) return false;
            }
        }

        return true;
    }
}
