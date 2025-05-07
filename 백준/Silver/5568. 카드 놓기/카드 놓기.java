import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] A;
    static Set<Integer> result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        A = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(br.readLine());

        result = new HashSet<>();
        dfs(0, 0, "");

        System.out.println(result.size());
    }

    static void dfs(int depth, int idx, String now) {
        if (depth == k) {
            result.add(Integer.parseInt(now));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1, now + A[i]);
                visited[i] = false;
            }
        }
    }
}
