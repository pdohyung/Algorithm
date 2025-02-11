import java.util.*;
import java.io.*;

public class Main {

    static int N, R, Q, cnt;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] tree;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        graph = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        makeTree(R, -1);
//        for (int i = 1; i <= N; i++) System.out.println(tree[i]);
        countSubtree(R);

        StringBuilder answer = new StringBuilder();

        for (int q = 0; q < Q; q++) {
            int target = Integer.parseInt(br.readLine());
            answer.append(result[target]).append("\n");
        }

        System.out.println(answer);
    }

    private static void countSubtree(int now) {
        result[now] = 1;

        for (int next : tree[now]) {
            countSubtree(next);
            result[now] += result[next];
        }
    }

    private static void makeTree(int now, int parent) {
        for (int next : graph[now]) {
            if (next != parent) {
                tree[now].add(next);
                makeTree(next, now);
            }
        }
    }
}
