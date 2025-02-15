
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[i][0] = start;
            A[i][1] = end;
        }

        Arrays.sort(A, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int before = A[0][0];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int start = A[i][0];
            int end = A[i][1];

            if (start > before) before = start;

            if (before < end) answer += end - before;

            before = Math.max(before, end);
        }

        System.out.println(answer);
    }
}
