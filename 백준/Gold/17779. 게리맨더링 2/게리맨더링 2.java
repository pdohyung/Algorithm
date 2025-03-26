
import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[][] A, map;
    static boolean[][] isLine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // d1, d2 반복문
                for (int d1 = 1; d1 <= y; d1++) {
                    for (int d2 = 1; d2 < N - y; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        // 경계선 결정
                        line(x, y, d1, d2);
                        // 지역 선거구 결정
                        setPlace(x, y, d1, d2);
                        // 최대, 최소 인구 선거구의 차이가 최소인 경우, 업데이트
                        answer = Math.min(answer, diff());
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int diff() {
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cnt.put(map[i][j], cnt.getOrDefault(map[i][j], 0) + A[i][j]);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int key : cnt.keySet()) {
            min = Math.min(min, cnt.get(key));
            max = Math.max(max, cnt.get(key));
        }

        return max - min;
    }

    private static void setPlace(int x, int y, int d1, int d2) {
        map = new int[N][N];

        // 1번 선거구
        for (int i = 0; i < x + d1; i++)
            for (int j = 0; j <= y; j++) {
                if (isLine[i][j]) break;
                map[i][j] = 1;
            }

        // 2번 선거구
        for (int i = 0; i <= x + d2; i++)
            for (int j = N - 1; j > y; j--) {
                if (isLine[i][j]) break;
                map[i][j] = 2;
            }

        // 3번 선거구
        for (int i = x + d1; i < N; i++)
            for (int j = 0; j < y - d1 + d2; j++) {
                if (isLine[i][j]) break;
                map[i][j] = 3;
            }

        // 4번 선거구
        for (int i = N - 1; i > x + d2; i--)
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (isLine[i][j]) break;
                map[i][j] = 4;
            }

        // 5번 선거구
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == 0) map[i][j] = 5;
    }

    private static void line(int x, int y, int d1, int d2) {
        isLine = new boolean[N][N];
        isLine[x][y] = true;
        for (int i = 1; i <= d1; i++) isLine[x + i][y - i] = true;
        for (int i = 1; i <= d2; i++) isLine[x + i][y + i] = true;
        for (int i = 1; i <= d2; i++) isLine[x + d1 + i][y - d1 + i] = true;
        for (int i = 1; i <= d1; i++) isLine[x + d2 + i][y + d2 - i] = true;
    }
}
