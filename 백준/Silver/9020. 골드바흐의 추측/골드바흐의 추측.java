
import java.util.*;
import java.io.*;

public class Main {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prime = new boolean[10_001];
        prime[2] = true;
        prime[3] = true;

        Arrays.fill(prime, true);

        for (int i = 4; i <= 10_000; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    prime[i] = false;
                    break;
                }
            }
        }

//        System.out.println(Arrays.toString(prime));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int half = N / 2;

            for (int j = 0; j < half; j++) {
                int low = half - j;
                int high = half + j;

                if (prime[low] && prime[high]) {
                    answer.append(low).append(" ").append(high).append("\n");
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
