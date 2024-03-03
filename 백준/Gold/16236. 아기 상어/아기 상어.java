import java.io.*;
import java.util.*;

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] movableMap;
    static boolean[][] visit;
    static Node babyShark;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    babyShark = new Node(i, j);
                }
            }
        }

        int time = 0;
        int babySharkSize = 2;
        int tempSize = babySharkSize;
        int minDistance;
        Node moveNode = null;

        while (true) {
            minDistance = Integer.MAX_VALUE;
            movableMap = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > babySharkSize) {
                        visit[i][j] = true;
                    }
                }
            }

            //System.out.println("babySharkSize " + babySharkSize);

            bfs(babySharkSize);

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
//
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(movableMap[i]));
//            }

            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] != 0 && babySharkSize > map[i][j] && movableMap[i][j] > 0) {
                        //System.out.println("cal min x,y " + i + " " + j);
                        if (minDistance >= movableMap[i][j]) {
                            moveNode = new Node(i, j);
                            minDistance = Math.min(minDistance, movableMap[i][j]);
                        }
                    }
                }
            }

            //System.out.println("moveNode x, y, distance " + moveNode.getX() + " " + moveNode.getY() + " " + minDistance);

            if (minDistance == Integer.MAX_VALUE) {
                break;
            }

            babyShark = new Node(moveNode.getX(), moveNode.getY());
            map[moveNode.getX()][moveNode.getY()] = 0;
            time += minDistance;
            tempSize--;

            if (tempSize == 0) {
                babySharkSize++;
                tempSize = babySharkSize;
            }
            //System.out.println("-----------------------------");
        }

        System.out.println(time);
    }

    private void bfs(int babySharkSize) {
        Queue<Node> q = new LinkedList<>();
        q.add(babyShark);
        visit[babyShark.getX()][babyShark.getY()] = true;
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowNode.getX() + dx[i];
                int ny = nowNode.getY() + dy[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visit[nx][ny]) continue;
                if (map[nx][ny] > babySharkSize) continue;
                //System.out.println("nx, ny " + nx + " " + ny);
                visit[nx][ny] = true;
                movableMap[nx][ny] = movableMap[nowNode.getX()][nowNode.getY()] + 1;
                q.add(new Node(nx, ny));
            }
        }
    }
}