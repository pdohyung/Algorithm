import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[N + 1];
        Arrays.fill(cnt, 1);

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                cnt[j] += i;
            }
        }

        long result = 0;

        for (int i = 1; i <= N; i++) {
            result += cnt[i];
        }

        System.out.println(result);
    }
}
