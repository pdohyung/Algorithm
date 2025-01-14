import java.io.*;
import java.util.*;

public class Main {

    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        result = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = ' ';
            }
        }

        recursive(0, 0, N);
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(result[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static void recursive(int x, int y, int n) {
        if (n == 1) {
            result[x][y] = '*';
            return;
        }

        int divN = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    recursive(x + i * divN, y + j * divN, divN);
                }
            }
        }
    }
}
