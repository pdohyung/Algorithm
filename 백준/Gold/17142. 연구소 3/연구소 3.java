
import java.util.*;
import java.io.*;

class virus {
    int x, y;

    public virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, cnt, answer;
    static int[][] map;
    static List<virus> viruses;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) num *= -1;
                else if (num == 2) {
                    viruses.add(new virus(i, j));
                    num *= -1;
                } else cnt++;
                map[i][j] = num;
            }
        }

        answer = Integer.MAX_VALUE;
        // 바이러스로 백트래킹 
        dfs(0, 0, new ArrayList<>());
        // 만약 끝이 아니라, 중간에 비활성 바이러스가 있다면 지나가야 함.
        // 하지만 마지막이라면 0인 칸이 없으므로 굳이 안 지나도 됨.
        // 이걸 구현하는게 중요할 듯 -> cnt로 구현
        if (answer == 0) System.out.println(0);
        else if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer - 1);
    }

    private static void dfs(int depth, int idx, List<virus> now) {
        if (depth == M) {
            // bfs 수행
            answer = Math.min(answer, bfs(now));
//            int[][] newMap = bfs(now);
//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(newMap[i]));
//            System.out.println();
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            virus v = viruses.get(i);
            now.add(v);
            dfs(depth + 1, i + 1, now);
            now.remove(v);
        }
    }

    //    private static int[][] bfs(List<virus> now) {
    private static int bfs(List<virus> now) {
//        System.out.println(cnt);
//        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
//        System.out.println();
        // newMap, newCnt 생성
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) newMap[i] = map[i].clone();
        int newCnt = cnt;
        int result = 0;

        for (virus v : now) newMap[v.x][v.y] = 1;
        Queue<virus> q = new ArrayDeque<>(now);

        while (!q.isEmpty()) {
            virus v = q.poll();
            int x = v.x;
            int y = v.y;

            for (int i = 0; i < 4; i++) {
                if (newCnt == 0) return result;
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || newMap[nx][ny] > 0 || newMap[nx][ny] == -1) continue;
                if (newMap[nx][ny] == 0) newCnt--;

                newMap[nx][ny] = newMap[x][y] + 1;
                result = newMap[nx][ny];
                q.add(new virus(nx, ny));
//                if (newCnt == 0) return newMap;
            }
        }
//        return newMap;
        return cnt == 0 ? result : Integer.MAX_VALUE;
    }
}
