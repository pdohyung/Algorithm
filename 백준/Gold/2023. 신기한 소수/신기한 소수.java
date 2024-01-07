import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int n) {
        if (n == N) {
            if (isPrimeNumber(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrimeNumber(num * 10 + i)) {
                dfs(num * 10 + i, n + 1);
            }
        }
    }

    private static boolean isPrimeNumber(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}