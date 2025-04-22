
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
    static List<Node> zero;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        zero = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 0) zero.add(new Node(i, j));
                board[i][j] = now;
            }
        }

        flag = false;
        dfs(0);
    }

    static void dfs(int depth) {
        if (flag) return;
        if (depth == zero.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            flag = true;
            return;
        }

        Node z = zero.get(depth);
        int x = z.x;
        int y = z.y;

        for (int n = 1; n <= 9; n++) {
            if (isValid(x, y, n)) {
                board[x][y] = n;
                dfs(depth + 1);
                if (flag) return;
                board[x][y] = 0;
            }
        }
    }

    static boolean isValid(int x, int y, int n) {

        for (int i = 0; i < 9; i++) {
            if (board[x][i] == n) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][y] == n) return false;
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;

        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (board[i][j] == n) return false;
            }
        }

        return true;
    }
}
