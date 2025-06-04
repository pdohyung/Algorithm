
import java.util.*;
import java.io.*;

class Node {
    int x, y, d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] c = {0, 2, 1, 4, 3};

    public static void main(String[] args) throws IOException {
        // NxN 체스판, 말의 개수는 K개, 하나의 말 위에 다른 말을 올릴 수 있음, 각 칸은 흰색, 빨간색, 파란색으로 칠해져있음
        // 체스판 위에 말 K개를 놓고 시작, 말은 1번부터 K번까지 번호, 이동 방향은 위, 아래, 왼쪽, 오른쪽
        // 이동하려는 칸이 흰색인 경우, 그냥 이동, 빨강인 경우, 이동 후에 쌓인 말의 순서를 반대로 바꿈, 파랑인 경우 반대로 방향을 바꾸고 이동, 방향을 바꿨는데 파랑인 경우, 가만히 있는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] infos = new Node[K + 1];
        int[][] M = new int[N + 1][N + 1];
        List<Integer>[][] B = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
                B[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            B[x][y].add(i);
            infos[i] = new Node(x, y, d);
        }

        int cnt = 0;

        while (cnt++ <= 1000) {
            for (int i = 1; i <= K; i++) {
                Node now = infos[i];
                int x = now.x;
                int y = now.y;
                int d = now.d;
                List<Integer> current = B[x][y];
                int idx = current.indexOf(i);

                List<Integer> moving = new ArrayList<>(current.subList(idx, current.size()));
                current.subList(idx, current.size()).clear();

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (outRange(nx, ny, N) || M[nx][ny] == 2) {
                    d = now.d = c[d];
                    nx = x + dx[d];
                    ny = y + dy[d];

                    if (outRange(nx, ny, N) || M[nx][ny] == 2) {
                        B[x][y].addAll(moving);
                        continue;
                    }
                }

                if (M[nx][ny] == 1) {
                    Collections.reverse(moving);
                }

                for (int m : moving) {
                    infos[m].x = nx;
                    infos[m].y = ny;
                    B[nx][ny].add(m);
                }

                if (B[nx][ny].size() >= 4) {
                    System.out.println(cnt);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    static boolean outRange(int nx, int ny, int N) {
        return nx < 1 || nx > N || ny < 1 || ny > N;
    }
}
