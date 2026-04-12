import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 10000;
        boolean[] prime = new boolean[N];
        Arrays.fill(prime, true);

        for (int i = 2; i < N; i++) {
            for (int j = i + i; j < N; j += i) {
                prime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            boolean[] visited  = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{A, 0});
            visited[A] = true;
            int result = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int num = cur[0];
                int cnt = cur[1];

                if (num == B) {
                    result = cnt;
                    break;
                }

                String strNum = String.valueOf(num);

                for (int j = 0; j < 4; j++) { // 자릿수 (0~3)
                    char[] chars = strNum.toCharArray();
                    for (int k = 0; k <= 9; k++) { // 바꿀 숫자 (0~9)
                        if (j == 0 && k == 0) continue; // 천의 자리는 0이 될 수 없음

                        chars[j] = (char) (k + '0');
                        int nextNum = Integer.parseInt(new String(chars));

                        if (prime[nextNum] && !visited[nextNum]) {
                            visited[nextNum] = true;
                            q.offer(new int[]{nextNum, cnt + 1});
                        }
                    }
                }
            }

            sb.append(result == Integer.MAX_VALUE ? "Impossible" : result).append("\n");
        }

        System.out.println(sb);
    }
}
