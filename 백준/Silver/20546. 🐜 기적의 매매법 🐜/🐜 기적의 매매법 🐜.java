import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[15];

        for (int i = 1; i <= 14; i++) cost[i] = Integer.parseInt(st.nextToken());

        int jStk = 0;
        int jAmt = cash;
        int sStk = 0;
        int sAmt = cash;
        int tp = 0;
        int bfTp = -1;
        int seq = 0;
        int bfCost = cost[1];

        for (int i = 1; i <= 14; i++) {
            if (cost[i] > bfCost) {
                tp = 1;
            } else if (cost[i] < bfCost) {
                tp = 2;
            } else {
                tp = 0;
            }

            if (tp == 0) {
                seq = 0;
            } else if (tp != bfTp) {
                seq = 1;
            } else seq++;

            bfCost = cost[i];
            bfTp = tp;

            if (seq >= 3) {
                if (tp == 1) {
                    sAmt += sStk * cost[i];
                    sStk = 0;
                } else if (tp == 2) {
                    int cnt = sAmt / cost[i];
                    sStk += cnt;
                    sAmt -= cnt * cost[i];
                }
            }

            if (jAmt >= cost[i]) {
                int cnt = jAmt / cost[i];
                jStk += cnt;
                jAmt -= cnt * cost[i];
            }
        }

        int jResult = jAmt + jStk * cost[14];
        int sResult = sAmt + sStk * cost[14];

        if (jResult > sResult) System.out.println("BNP");
        else if (jResult < sResult) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
