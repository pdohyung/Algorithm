import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> multitap = new HashSet<>();
        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) order[i] = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < K; i++) {
            int now = order[i];

            if (multitap.contains(now)) continue;
            else if (multitap.size() < N) {
                multitap.add(now);
                continue;
            }

            int before = -1;
            int target = -1;

            for (int j : multitap) {
                int next = Integer.MAX_VALUE;

                for (int k = i + 1; k < K; k++) {
                    if (j == order[k]) {
                        next = k;
                        break;
                    }
                }

                if (next > before) {
                    before = next;
                    target = j;
                }
            }

            multitap.remove(target);
            multitap.add(now);
            result++;
        }

        System.out.println(result);
    }
}
