import java.util.*;
import java.io.*;

public class Main {

    static boolean[] isPrime;
    static int limit = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) { // i가 소수라면
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false; // i의 배수는 소수가 아님
                }
            }
        }

//        System.out.println(Arrays.toString(isPrime));

        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            int start = 3;
            int end = N;

            while (start <= end / 2) {
                if (isPrime[start] && isPrime[end - start]) {
                    answer.append(N).append(" = ").append(start).append(" + ").append(end - start).append("\n");
                    break;
                }
                start += 2;
            }

            N = Integer.parseInt(br.readLine());
        }

        System.out.println(answer);
    }
}
