
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 도시를 여행, 각 도시간의 연결 정보가 주어짐, 마지막 줄에 여행 경로가 가능하지 출력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            result.add(find(now));
        }

        if (result.size() > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    static int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rX = find(x);
        int rY = find(y);
        if (rX != rY) parent[rY] = rX;
    }
}
