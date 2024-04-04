import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N;
    static char[][] room;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        room = new char[101][101];
        int row = 0;
        int col = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int checkRow = 0, checkCol = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') checkRow++;
                if (room[i][j] == 'X' || (j == N - 1)) {
                    if (checkRow >= 2) row++;
                    checkRow = 0;
                }

                if (room[j][i] == '.') checkCol++;
                if (room[j][i] == 'X' || (j == N - 1)) {
                    if (checkCol >= 2) col++;
                    checkCol = 0;
                }
            }
        }

        System.out.println(row + " " + col);
    }
}