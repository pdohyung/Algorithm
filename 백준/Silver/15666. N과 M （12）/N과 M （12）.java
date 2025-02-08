import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] A;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            dfs(i, 1, "" + A[i]);
        }

//        System.out.println(answer);
        for (String s : answer) System.out.println(s);
    }

    private static void dfs(int idx, int depth, String result) {
        if (depth == M) {
            if (!answer.contains(result)) answer.add(result);
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(i, depth + 1, result + " " + A[i]);
        }
    }
}
