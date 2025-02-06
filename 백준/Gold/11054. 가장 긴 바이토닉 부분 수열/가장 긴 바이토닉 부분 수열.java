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

        int[] dpIn = new int[N];
        int[] dpDe = new int[N];
        Arrays.fill(dpIn, 1);
        Arrays.fill(dpDe, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dpIn[i] = Math.max(dpIn[i], dpIn[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dpDe[i] = Math.max(dpDe[i], dpDe[j] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dpIn));
//        System.out.println(Arrays.toString(dpDe));

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dpIn[i] + dpDe[i] - 1);
        }

        System.out.println(answer);
    }
}
