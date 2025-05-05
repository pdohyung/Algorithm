import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());

        int[] cnt = new int[2];
        int r = 2;
        int now = 0;

        while (cnt[0] < 10_000 || cnt[1] < 10_000) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    cnt[j]++;

                    if (cnt[type] == T) {
                        System.out.println(now);
                        return;
                    }

                    now = (now + 1) % A;
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < r; j++) {
                    cnt[i]++;

                    if (cnt[type] == T) {
                        System.out.println(now);
                        return;
                    }

                    now = (now + 1) % A;
                }
            }

            r++;
        }
    }
}
