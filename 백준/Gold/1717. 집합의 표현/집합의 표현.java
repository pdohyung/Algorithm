import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] nodes;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(a, b);
            } else {
                if (isSame(a, b)) {
                    System.out.println("YES");
                    continue;
                }
                System.out.println("NO");
            }
        }
    }

    private void union(int a, int b) { // 대표 노드를 찾아서 집합을 합침
        a = find(a);
        b = find(b);

        if (a != b) {
            nodes[b] = a;
        }
    }

    private int find(int n) { // 대표 노드 찾기
        if (nodes[n] == n) {
            return n;
        } else {
            return nodes[n] = find(nodes[n]);
        }
    }

    private boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }

        return false;
    }

}