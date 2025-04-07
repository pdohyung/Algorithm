import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(br.readLine());

        Set<Integer> answer = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            List<Integer> result = find(i);
            if (result.isEmpty()) continue;
            answer.addAll(result);
        }

        System.out.println(answer.size());
        for (int n : answer) System.out.println(n);
    }

    private static List<Integer> find(int start) {
        boolean[] visited = new boolean[N + 1];
        List<Integer> result = new ArrayList<>();
        result.add(start);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            int next = a[now];

            if (next == start) return result;
            if (visited[next]) continue;

            visited[next] = true;
            result.add(next);
            q.add(next);
        }

        return new ArrayList<>();
    }
}
