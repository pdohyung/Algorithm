import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] muscle = new long[N];
        for (int i = 0; i < N; i++) muscle[i] = Long.parseLong(st.nextToken());

        Arrays.sort(muscle);

        if (N == 1) {
            System.out.println(muscle[0]);
            return;
        }

        int start = 0;
        int end = N - 1;
        long M = Long.MIN_VALUE;
        if (N % 2 == 1) {
            M = muscle[N - 1];
            end--;
        }

        while (start < end) {
            M = Math.max(M, muscle[start++] + muscle[end--]);
        }

        System.out.println(M);
    }
}
