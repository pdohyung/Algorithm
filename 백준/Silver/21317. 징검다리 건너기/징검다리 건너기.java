import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp, smallJump, bigJump;
    static int N, veryBigJump;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        smallJump = new int[N];
        bigJump = new int[N];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            smallJump[i] = Integer.parseInt(st.nextToken());
            bigJump[i] = Integer.parseInt(st.nextToken());
        }

        veryBigJump = Integer.parseInt(br.readLine());

        dp[0] = 0;
        if (N > 1) dp[1] = smallJump[0];
        if (N > 2) dp[2] = Math.min(smallJump[0] + smallJump[1], bigJump[0]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.min(dp[i - 1] + smallJump[i - 1], dp[i - 2] + bigJump[i - 2]);
        }

        int minEnergy = dp[N - 1];
        
        for (int i = 0; i < N - 3; i++) {
            int energyWithK = dp[i] + veryBigJump;
            int[] tempDp = dp.clone();
            tempDp[i + 3] = energyWithK;
            
            for (int j = i + 4; j < N; j++) {
                tempDp[j] = Math.min(tempDp[j - 1] + smallJump[j - 1], tempDp[j - 2] + bigJump[j - 2]);
            }

            minEnergy = Math.min(minEnergy, tempDp[N - 1]);
        }

        System.out.println(minEnergy);
    }
}
