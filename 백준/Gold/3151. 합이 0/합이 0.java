
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] cnt = new int[20_001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            cnt[A[i] + 10_000]++;
        }

        Arrays.sort(A);

        long answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = A[i] + A[j];

                if (Math.abs(target) > 10_000) continue;

                answer += cnt[-target + 10_000];

                if (A[i] == -target) answer--;
                if (A[j] == -target) answer--;
            }
        }

        System.out.println(answer / 3);
    }
}
