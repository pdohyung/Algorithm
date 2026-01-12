import java.util.*;
import java.io.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M;
    static int[][] result, map;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        map = maps;
        N = maps.length;
        M = maps[0].length;
        result = new int[N][M];
        visited = new boolean[N][M];
        bfs(new Node(0, 0));
        if (result[N - 1][M - 1] == 0) return -1;
        else return result[N - 1][M - 1];
    }

    static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        result[start.x][start.y] = 1;

        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || result[nx][ny] != 0 || map[nx][ny] == 0) continue;
                result[nx][ny] = result[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}
