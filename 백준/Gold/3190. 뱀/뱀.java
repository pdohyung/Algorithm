
import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> dirInfos = new LinkedHashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirInfos.put(sec, dir);
        }

        int sec = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        ArrayDeque<Node> d = new ArrayDeque<>();
        d.add(new Node(x, y));

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 자신의 몸과 부딪힌 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == -1) {
                sec++;
                break;
            }

            // 사과가 없다면 꼬리 제거
            if (map[nx][ny] == 0) {
                Node tail = d.poll();
                map[tail.x][tail.y] = 0;
            }

            // 머리 영역 추가
            map[nx][ny] = -1;
            d.add(new Node(nx, ny));
            x = nx;
            y = ny;
            sec++;

            // 방향 전환
            if (dirInfos.containsKey(sec)) {
                if (dirInfos.get(sec) == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }

//            // 출력
//            System.out.println(sec);
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
        }
        System.out.println(sec);
    }
}
