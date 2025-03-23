
import java.util.*;
import java.io.*;

public class Main {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) answer++;
            if (checkCol(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkRow(int i) {
        boolean[] visited = new boolean[N];

        for (int j = 0; j < N - 1; j++) {
            int now = map[i][j];
            int next = map[i][j + 1];

            if (now == next) continue;
            if (Math.abs(now - next) > 1) return false;

            if (next - now == 1) { // 왼쪽 경사로
                for (int k = 0; k < L; k++) {
                    if (j - k < 0 || map[i][j - k] != now || visited[j - k]) return false;
                    visited[j - k] = true;
                }
            } else if (now - next == 1) { // 오른쪽 경사로
                for (int k = 1; k <= L; k++) {
                    if (j + k >= N || map[i][j + k] != next || visited[j + k]) return false;
                    visited[j + k] = true;
                }
            }
        }

        return true;
    }

    private static boolean checkCol(int i) {
        boolean[] visited = new boolean[N];

        for (int j = 0; j < N - 1; j++) {
            int now = map[j][i];
            int next = map[j + 1][i];

            if (now == next) continue;
            if (Math.abs(now - next) > 1) return false;

            if (next - now == 1) { // 왼쪽 경사로
                for (int k = 0; k < L; k++) {
                    if (j - k < 0 || map[j - k][i] != now || visited[j - k]) return false;
                    visited[j - k] = true;
                }
            } else if (now - next == 1) {
                for (int k = 1; k <= L; k++) {
                    if (j + k >= N || map[j + k][i] != next || visited[j + k]) return false;
                    visited[j + k] = true;
                }
            }
        }

        return true;
    }
}
