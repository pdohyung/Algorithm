import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] s, int[] e) {
                if (s[1] == e[1]) {
                    return s[0] - e[0];
                }

                return s[1] - e[1];
            }
        });

        int cnt = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (times[i][0] >= end) {
                cnt++;
                end = times[i][1];
            }
        }

        System.out.println(cnt);
    }
}