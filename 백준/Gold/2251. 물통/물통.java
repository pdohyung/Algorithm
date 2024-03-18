import java.io.*;
import java.util.*;

class AB {
    private final int a;
    private final int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] startP = {0, 0, 1, 1, 2, 2};
    static int[] endP = {1, 2, 0, 2, 0, 1};
    static boolean[][] visit;
    static Set<Integer> answer;
    static int now[];

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        now = new int[3];
        visit = new boolean[201][201];
        answer = new LinkedHashSet<>();

        for (int i = 0; i < 3; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        answer.stream().sorted().forEach(num -> System.out.print(num + " "));

    }

    private void bfs() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0)); // A, B 물통이 0인 경우
        visit[0][0] = true;
        answer.add(now[2]);
        
        while (!q.isEmpty()) {
            AB nowAB = q.poll();
            int A = nowAB.getA();
            int B = nowAB.getB();
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++) {
                int next[] = {A, B, C};
                next[endP[i]] += next[startP[i]];
                next[startP[i]] = 0;

                if (next[endP[i]] > now[endP[i]]) {
                    next[startP[i]] = next[endP[i]] - now[endP[i]];
                    next[endP[i]] = now[endP[i]];
                }
                if (visit[next[0]][next[1]]) continue;

                q.add(new AB(next[0], next[1]));
                visit[next[0]][next[1]] = true;

                if (next[0] == 0) {
                    answer.add(next[2]);
                }

            }
        }
    }

}