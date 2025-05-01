
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] things = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) things[i] = Integer.parseInt(st.nextToken());

        Set<Integer> multitap = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            int thing = things[i];

            if (multitap.contains(thing)) continue;
            else if (multitap.size() < N) {
                multitap.add(thing);
                continue;
            }

            int before = -1;
            int target = -1;

            for (int m : multitap) {
                int next = Integer.MAX_VALUE;

                for (int j = i + 1; j < K; j++) {
                    if (things[j] == m) {
                        next = j;
                        break;
                    }
                }

                if (next > before) {
                    before = next;
                    target = m;
                }
            }

            multitap.remove(target);
            multitap.add(thing);
            cnt++;
        }

        System.out.println(cnt);
    }
}
