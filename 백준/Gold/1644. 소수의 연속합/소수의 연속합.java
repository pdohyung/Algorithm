import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);

        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (prime[i]) primes.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = primes.get(0);
        int cnt = 0;

        while (true) {
            while (sum < N) {
                end++;
                if (end == primes.size()) break;
                sum += primes.get(end);
            }

            if (sum < N) break;
            if (sum == N) cnt++;
            sum -= primes.get(start++);
        }

        System.out.println(cnt);
    }
}
