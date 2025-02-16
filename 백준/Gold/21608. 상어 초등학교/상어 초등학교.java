
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int cnt;
    int blank;

    public Node(int x, int y, int cnt, int blank) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.blank = blank;
    }
}

public class Main {

    static int N;
    static int[][] board;
    static Map<Integer, List<Integer>> students;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        students = new LinkedHashMap<>();

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> now = students.getOrDefault(num, new ArrayList<>());
            for (int j = 0; j < 4; j++) now.add(Integer.parseInt(st.nextToken()));
            students.put(num, now);
        }

        for (int key : students.keySet()) {
            ArrayList<Node> result = getFavorite(students.get(key));
            Node now = getBest(result);
            board[now.x][now.y] = key;
        }

        int answer = getScore();
        System.out.println(answer);
    }

    private static int getScore() {
        int score = 0;
        int[] scores = {0, 1, 10, 100, 1000};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = board[i][j];
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (students.get(student).contains(board[nx][ny])) cnt++;
                }
                score += scores[cnt];
            }
        }
        return score;
    }

    private static Node getBest(ArrayList<Node> result) {
        return Collections.min(result, (a, b) -> {
            if (a.cnt != b.cnt) return Integer.compare(b.cnt, a.cnt); // 좋아하는 학생이 많은 자리
            if (a.blank != b.blank) return Integer.compare(b.blank, a.blank); // 빈 칸이 많은 자리
            if (a.x != b.x) return Integer.compare(a.x, b.x); // 행 번호가 작은 자리
            return Integer.compare(a.y, b.y); // 열 번호가 작은 자리
        });
    }

    private static ArrayList<Node> getFavorite(List<Integer> favorite) {
        ArrayList<Node> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) continue;
                int cnt = 0;
                int blank = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (favorite.contains(board[nx][ny])) cnt++;
                    if (board[nx][ny] == 0) blank++;
                }
                result.add(new Node(i, j, cnt, blank));
            }
        }
        return result;
    }
}
