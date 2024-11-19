import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] value = {1, 5, 10, 50};
    static Set<Integer> uniqueSum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        uniqueSum = new HashSet<>();

        N = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);

        System.out.println(uniqueSum.size());
    }

    public static void dfs(int depth, int sum, int start) {
        if (depth == N) {
            uniqueSum.add(sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            dfs(depth + 1, sum + value[i], i);
        }
    }
}
