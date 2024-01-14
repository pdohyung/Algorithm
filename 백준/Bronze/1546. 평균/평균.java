import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        double max = 0;
        st = new StringTokenizer(br.readLine());
        List<Double> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double score = Integer.parseInt(st.nextToken());
            scores.add(score);
            max = Math.max(max, score);
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += scores.get(i) / max * 100;
        }

        System.out.println(sum / n);
    }
}