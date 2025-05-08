
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) h[i] = Integer.parseInt(st.nextToken());

        left[0] = h[0];
        right[N - 1] = h[N - 1];
        for (int i = 1; i < N; i++) left[i] = left[i - 1] + h[i];
        for (int i = N - 2; i >= 0; i--) right[i] = right[i + 1] + h[i];

        int result = 0;

        // 벌-벌-벌통
        for (int i = 1; i < N; i++) {
            result = Math.max(result, (left[N - 1] - h[0] - h[i]) + (left[N - 1] - left[i]));
        }

        // 벌-벌통-벌
        for (int i = 1; i < N - 1; i++) {
            result = Math.max(result, (left[i] - h[0]) + (right[i] - h[N - 1]));
        }

        // 벌통-벌-벌
        for (int i = N - 2; i >= 1; i--) {
            result = Math.max(result, (right[0] - h[N - 1] - h[i]) + (right[0] - right[i]));
        }

        System.out.println(result);
    }
}
