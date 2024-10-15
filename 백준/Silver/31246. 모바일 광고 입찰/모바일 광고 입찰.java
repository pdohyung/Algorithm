import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> diff = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int moloco = Integer.parseInt(st.nextToken());
            int other = Integer.parseInt(st.nextToken());

            if (moloco >= other) {
                cnt++;
                continue;
            }
            diff.add(other - moloco);
        }

        //System.out.println(cnt);

        if (cnt >= K) {
            System.out.println(0);
            return;
        }

        Collections.sort(diff);

        System.out.println(diff.get(K - cnt - 1));
    }
}
