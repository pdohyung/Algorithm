
import java.util.*;
import java.io.*;

class Node {
    int h, x;

    public Node(int h, int x) {
        this.h = h;
        this.x = x;
    }
}

public class Main {

    static int N, M, H, answer;
    static boolean[][] ladder;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new boolean[H][N];
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            ladder[a][b] = true;
        }

        for (int i = 0; i < H; i++)
            for (int j = 0; j < N; j++)
                if (isValid(ladder, i, j)) list.add(new Node(i, j));
        
        answer = Integer.MAX_VALUE;
        for (int t = 0; t <= 3; t++) {
            dfs(0, 0, t);
            if (answer != Integer.MAX_VALUE) break; // 가장 빠른 정답 찾으면 종료
        }

        if (answer > 3) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int depth, int idx, int target) {
        if (depth == target) {
            if (down()) answer = depth;
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            Node now = list.get(i);
            int h = now.h;
            int x = now.x;

            if (!isValid(ladder, h, x)) continue;

            ladder[h][x] = true;
            dfs(depth + 1, i + 1, target);
            ladder[h][x] = false;
        }
    }

    private static boolean down() {
        for (int s = 0; s < N; s++) {
            int x = s;
            for (int h = 0; h < H; h++) {
                if (x < N - 1 && ladder[h][x]) x++;
                else if (x > 0 && ladder[h][x - 1]) x--;
            }
            if (x != s) return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] now, int h, int x) {
        if (now[h][x]) return false;
        if (x == 0 && now[h][x + 1]) return false;
        if (x == N - 1 && now[h][x - 1]) return false;
        if ((x > 0 && now[h][x - 1]) || (x < N - 1 && now[h][x + 1])) return false;
        return true;
    }
}
