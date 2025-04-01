
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;

            char[][] board = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line.charAt(3 * i + j);
                    if (board[i][j] == 'X') xCnt++;
                    else if (board[i][j] == 'O') oCnt++;
                }
            }

            if (xCnt + oCnt == 9 && xCnt - oCnt == 1) {
                if (check(board, 'X') && check(board, 'O')) answer.append("invalid");
                else if (check(board, 'O')) answer.append("invalid");
                else answer.append("valid");
            } else {
                if (check(board, 'X') && check(board, 'O')) answer.append("invalid");
                else if (check(board, 'X') && xCnt - oCnt == 1) answer.append("valid");
                else if (check(board, 'O') && xCnt == oCnt) answer.append("valid");
                else answer.append("invalid");
            }

            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static boolean check(char[][] board, char now) {
        // 가로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == now) cnt++;
            }
            if (cnt == 3) return true;
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == now) cnt++;
            }
            if (cnt == 3) return true;
        }

        // 대각선
        if (board[0][0] == now && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] == now && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;

        return false;
    }
}
