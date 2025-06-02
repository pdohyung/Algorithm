
import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[][] B;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 두 팀이 공격과 수비를 번갈아 가며 게임, N이닝 동안 진행, 3아웃이 발생하면 교체
        // 타순을 미리 정해야하고, 9번 타자까지 공을 쳤는데, 3아웃이 발생하지 않은 상태면 이닝은 그대로 진행
        // 안타: 1, 2루타: 2, 3루타: 3, 홈런: 4, 1번 선수를 4번 타자로 미리 정함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        B = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] now = new int[9];
        now[3] = 1;
        visited = new boolean[10];
        visited[1] = true;

        dfs(0, now);

        System.out.println(answer);
    }

    static void dfs(int depth, int[] result) {
        if (depth == 9) {
            answer = Math.max(answer, play(result));
            return;
        }

        if (depth == 3) {
            dfs(depth + 1, result);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = i;
            dfs(depth + 1, result);
            visited[i] = false;
        }
    }

    static int play(int[] result) {
        int next = 0;
        int score = 0;

        for (int i = 1; i <= N; i++) {
            int out = 0;
            boolean[] base = new boolean[3];

            while (out < 3) {
                int hit = B[i][result[next]];

                if (hit == 0) {
                    out++;
                } else if (hit == 1) {
                    if (base[2]) score++;
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = true;
                } else if (hit == 2) {
                    if (base[2]) score++;
                    if (base[1]) score++;
                    base[2] = base[0];
                    base[1] = true;
                    base[0] = false;
                } else if (hit == 3) {
                    for (int j = 2; j >= 0; j--) {
                        if (base[j]) score++;
                        base[j] = false;
                    }
                    base[2] = true;
                } else if (hit == 4) {
                    for (int j = 0; j < 3; j++) {
                        if (base[j]) score++;
                        base[j] = false;
                    }
                    score++;
                }

                next = (next + 1) % 9;
            }
        }

        return score;
    }
}
