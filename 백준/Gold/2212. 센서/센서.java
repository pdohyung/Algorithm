import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sensor = new int[N];
        for (int i = 0; i < N; i++) sensor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sensor);

        int[] dist = new int[N - 1];
        for (int i = 0; i < N - 1; i++) dist[i] = Math.abs(sensor[i + 1] - sensor[i]);

        Arrays.sort(dist);

        int answer = 0;
        for (int i = 0; i < N - 1 - (K - 1); i++) answer += dist[i];

        System.out.println(answer);
    }
}
