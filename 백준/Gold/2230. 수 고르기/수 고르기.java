
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while (start <= end) {
            int gap = Math.abs(A[start] - A[end]);

            if (gap >= M) answer = Math.min(answer, gap);

            if (end == N - 1) start++;
            else if (start == end) end++;
            else if (gap < M) end++;
            else start++;
        }

        System.out.println(answer);
    }
}
