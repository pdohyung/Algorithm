import java.util.*;
import java.io.*;

public class Main {
    static char[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        origin = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                origin[i][j] = line[j];
            }
        }

        int x = N - 8 + 1;
        int y = M - 8 + 1;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int result1 = find('B', i, j);
                int result2 = find('W', i, j);

                answer = Math.min(answer, result1);
                answer = Math.min(answer, result2);
            }
        }
        
        System.out.println(answer);
    }

    private static int find(char now, int i, int j) {
        int result = 0;

        for (int k = 0; k < 8; k++) {
            now = change(now);

            for (int l = 0; l < 8; l++) {
                if (origin[k + i][l + j] != now) result++;
                now = change(now);
            }
        }

        return result;
    }

    private static char change(char input) {
        if (input == 'B') return 'W';
        else return 'B';
    }
}
