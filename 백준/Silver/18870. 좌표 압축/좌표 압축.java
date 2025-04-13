import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> ranking = new HashMap<>();
        int[] origin = new int[N];
        int[] sorted = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            origin[i] = n;
            sorted[i] = n;
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int i = 0; i < N; i++) {
            int now = sorted[i];

            if (!ranking.containsKey(now)) {
                ranking.put(now, rank);
                rank++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) answer.append(ranking.get(origin[i])).append(" ");
        System.out.println(answer);
    }
}
