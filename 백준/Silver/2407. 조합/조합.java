
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BigInteger[][] dp = new BigInteger[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(comb(N, M));
    }

    static BigInteger comb(int n, int m) {
        if (m == 0 || n == m) return BigInteger.ONE;
        if (dp[n][m] != null) return dp[n][m];
        return dp[n][m] = comb(n - 1, m - 1).add(comb(n - 1, m));
    }
}
