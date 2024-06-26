import java.io.*;
import java.util.*;

class Solution {
    private static class Node {
        int x;
        int y;

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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static int[][] distance;
    static String[] map;
    static Node start, lever, exit;
    
    public int solution(String[] maps) {
        map = maps;
        // 레버와 출구 위치 노드 생성
        for (int i = 0; i < maps.length; i++) {
            char[] ca = maps[i].toCharArray();
            for (int j = 0; j < ca.length; j++) {
                if (ca[j] == 'S') {
                    start = new Node(i, j);
                    continue;
                }
                if (ca[j] == 'L') {
                    lever = new Node(i, j);
                    continue;
                }
                if (ca[j] == 'E') {
                    exit = new Node(i, j);
                }
            }
        }

        init();
        bfs(start, 'L');
        int leverDistance = distance[lever.getX()][lever.getY()];

        init();
        start = new Node(lever.getX(), lever.getY());
        bfs(start, 'E');
        int exitDistance = distance[exit.getX()][exit.getY()];

        if (leverDistance == 0 || exitDistance == 0) {
            return -1;
        }
        return leverDistance + exitDistance;
    }

    private static void init() {
        visit = new boolean[map.length][map[0].length()];
        distance = new int[map.length][map[0].length()];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(distance[i], 0);
        }
    }

    private static void bfs(Node start, Character target) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (ny < 0 || ny >= map[0].length() || nx < 0 || nx >= map.length) continue;
                if (visit[nx][ny] || map[nx].charAt(ny) == 'X') continue;
                if (map[nx].charAt(ny) == target) {
                    distance[nx][ny] = distance[now.getX()][now.getY()] + 1;
                    return;
                }

                visit[nx][ny] = true;
                distance[nx][ny] = distance[now.getX()][now.getY()] + 1;
                queue.add(new Node(nx, ny));
            }
        }
    }
}