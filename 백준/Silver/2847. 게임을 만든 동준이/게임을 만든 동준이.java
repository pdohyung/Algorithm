import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];
        for (int i = 0; i < N; i++) levels[i] = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int sum = 0;
        int cur = levels[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            int now = levels[i];
            if (now >= cur) {
                cur = cur - 1;
                sum += now - cur;
            } else cur = now;
        }

        System.out.println(sum);
    }
}
