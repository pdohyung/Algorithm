
import java.util.*;
import java.io.*;

class Node {
    int r, c, m, s, d;

    public Node(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {

    static int N, M, K;
    static List<Node>[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) map[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new Node(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {
            // 이동
            List<Node>[][] nextMap = new ArrayList[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    nextMap[i][j] = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Node now : map[i][j]) {
                        // 속도가 매우 클 경우 격자를 벗어나는 상황을 고려해 N으로 나눈 나머지를 사용
                        // 음수 좌표 방지를 위해 +N 후 다시 %N 처리
                        int nr = (now.r + dr[now.d] * now.s % N + N) % N;
                        int nc = (now.c + dc[now.d] * now.s % N + N) % N;
                        nextMap[nr][nc].add(new Node(nr, nc, now.m, now.s, now.d));
                    }
                }
            }

            // 합치기
            List<Node> result = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (nextMap[i][j].isEmpty()) continue;
                    else if (nextMap[i][j].size() == 1) {
                        result.add(nextMap[i][j].get(0));
                        continue;
                    }
                    // 2개 이상인 경우 합치기
                    int sumM = 0, sumS = 0;
                    boolean isAllOdd = true, isAllEven = true;

                    for (Node now : nextMap[i][j]) {
                        sumM += now.m;
                        sumS += now.s;

                        if (now.d % 2 == 0) isAllOdd = false;
                        if (now.d % 2 != 0) isAllEven = false;
                    }

                    int nextM = sumM / 5;
                    if (nextM == 0) continue;
                    int nextS = sumS / nextMap[i][j].size();
                    int[] nextDirs = (isAllOdd || isAllEven) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

                    for (int nextDir : nextDirs) result.add(new Node(i, j, nextM, nextS, nextDir));
                }
            }

            // map 초기화
            map = new List[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    map[i][j] = new ArrayList<>();

            // 이동된 결과를 다시 map에 채우기
            for (Node node : result) map[node.r][node.c].add(node);
        }

        int answer = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (Node node : map[i][j])
                    answer += node.m;

        System.out.println(answer);
    }
}
