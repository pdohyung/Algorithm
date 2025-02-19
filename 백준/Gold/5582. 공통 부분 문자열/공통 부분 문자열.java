
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line1 = br.readLine().toCharArray();
        char[] line2 = br.readLine().toCharArray();

        int length1 = line1.length;
        int length2 = line2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        int answer = 0;

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (line1[i - 1] == line2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
