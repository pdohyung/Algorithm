import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static List<Integer> scores;
    static int maxGap;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= K; i++) {
            maxGap = 0;
            st = new StringTokenizer(br.readLine());
            scores = new ArrayList<>();
            int N = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(scores);

            for (int j = 0; j < N - 1; j++) {
                int calcGap = scores.get(j + 1) - scores.get(j);
                maxGap = Math.max(maxGap, calcGap);
            }

            System.out.println("Class " + i);
            System.out.println("Max " + scores.get(N - 1) + ", Min " + scores.get(0) + ", Largest gap " + maxGap);
        }
    }
}