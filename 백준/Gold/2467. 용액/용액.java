
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

        int low = 0;
        int high = N - 1;

        int min = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (low < high) {
            int sum = A[low] + A[high];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer1 = A[low];
                answer2 = A[high];
            }

            if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
