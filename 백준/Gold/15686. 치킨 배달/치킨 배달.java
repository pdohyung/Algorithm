import java.io.*;
import java.util.*;

class Node {
    private final int X;
    private final int Y;

    public Node(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M;
    static boolean[] visit;
    static int[][] map;
    static List<Node> chicken;
    static List<Node> home;
    static int ans;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                    continue;
                }
                if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        visit = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(ans);
    }

    private void dfs(int start, int cnt) {
        if (cnt == M) {
            int res = 0;
            for (int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        int distance = Math.abs(home.get(i).getX() - chicken.get(j).getX())
                                + Math.abs(home.get(i).getY() - chicken.get(j).getY());
                        min = Math.min(min, distance);
                    }
                }
                res += min;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visit[i] = true;
            dfs(i + 1, cnt + 1);
            visit[i] = false;
        }
    }
}