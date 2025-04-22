import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0;
        int end = A.length - 1;
        int diff = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (start < end) {
            int result = A[start] + A[end];

            if (Math.abs(result) < diff) {
                diff = Math.abs(result);
                answer[0] = A[start];
                answer[1] = A[end];
            }

            if (result == 0) break;

            if (result < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
