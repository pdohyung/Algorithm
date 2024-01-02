import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(combination(m, n));
        }
    }

    private static int combination(int n, int r) {
        if (sum[n][r] != 0) {
            return sum[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        sum[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        return sum[n][r];
    }
}