import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) ropes[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ropes);

        int max = 0;
        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            int now = ropes[i];
            cnt++;
            max = Math.max(max, now * cnt);
        }

        System.out.println(max);
    }
}
