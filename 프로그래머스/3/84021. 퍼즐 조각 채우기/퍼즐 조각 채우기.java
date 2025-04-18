import java.util.*;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}

class Solution {
    int N;
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        visited = new boolean[N][N];

        List<List<Node>> empty = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && game_board[i][j] == 0) {
                    empty.add(normalize(bfs(game_board, i, j, 0)));
                }
            }
        }

        visited = new boolean[N][N];
        List<List<Node>> blocks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && table[i][j] == 1) {
                    blocks.add(normalize(bfs(table, i, j, 1)));
                }
            }
        }

        int answer = 0;

        for (List<Node> e : empty) {
            boolean matched = false;
            
            for (int i = 0; i < blocks.size(); i++) {
                List<Node> block = blocks.get(i);
                
                for (int r = 0; r < 4; r++) {
                    if (isSame(e, block)) {
                        answer += block.size();
                        blocks.remove(i);
                        matched = true;
                        break;
                    }
                    
                    block = rotate(block);
                }
                
                if (matched) break;
            }
        }

        return answer;
    }

    List<Node> bfs(int[][] board, int x, int y, int target) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        List<Node> shape = new ArrayList<>();
        shape.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    shape.add(new Node(nx - x, ny - y));
                }
            }
        }
        
        return shape;
    }

    List<Node> normalize(List<Node> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for (Node n : shape) {
            minX = Math.min(minX, n.x);
            minY = Math.min(minY, n.y);
        }
        List<Node> normalized = new ArrayList<>();
        
        for (Node n : shape) {
            normalized.add(new Node(n.x - minX, n.y - minY));
        }
        
        normalized.sort((a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(a.y, b.y);
        });
        
        return normalized;
    }

    List<Node> rotate(List<Node> shape) {
        List<Node> rotated = new ArrayList<>();
        
        for (Node n : shape) {
            rotated.add(new Node(n.y, -n.x));
        }
        
        return normalize(rotated);
    }

    boolean isSame(List<Node> a, List<Node> b) {
        if (a.size() != b.size()) return false;
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).x != b.get(i).x || a.get(i).y != b.get(i).y) return false;
        }
        
        return true;
    }
}
