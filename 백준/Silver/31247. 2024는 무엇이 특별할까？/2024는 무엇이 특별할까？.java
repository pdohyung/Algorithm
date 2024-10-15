import java.io.*;
import java.util.*;

public class Main {

    static long[] pow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pow = new long[64];
        pow[0] = 1;
        for (int i = 1; i <= 63; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            
            if (K >= 63)
                result.append(0).append("\n");
            else {
                int k = (int) K;
                long ans = (N / pow[k]);
                if (ans % 2 == 0)
                    result.append(ans / 2).append('\n');
                else
                    result.append(ans - (ans - 1) / 2).append('\n');
            }
        }
        System.out.println(result);
    }
}
