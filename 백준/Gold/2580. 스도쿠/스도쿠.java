
import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;
    static ArrayDeque<Node> targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[10][10];
        targets = new ArrayDeque<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 0) {
                    targets.push(new Node(i, j));
                }

                board[i][j] = num;
            }
        }

        dfs();
    }

    private static void dfs() {
        if (targets.isEmpty()) {
            printBoard(); // 출력
            System.exit(0);
        }

        Node target = targets.pop();

        for (int i = 1; i <= 9; i++) {
            if (isValid(i, target)) {
                board[target.x][target.y] = i;
                dfs(); // 다음 칸으로 이동
                board[target.x][target.y] = 0;
            }
        }

        targets.push(target);
    }

    private static boolean isValid(int num, Node target) {
        int row = target.x;
        int col = target.y;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
