import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans;
    static int[] energies;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        energies = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            energies[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        System.out.println(ans);
    }

    private static void solution(int cnt, int sum) {
        if (cnt == N - 2) {
            ans = Math.max(sum, ans);
        }

        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) {
                continue;
            }

            int left = i;
            int right = i;
            while (left-- > 0) {
                if (!visited[left]) {
                    break;
                }
            }

            while (right++ < N - 1) {
                if (!visited[right]) {
                    break;
                }
            }

            visited[i] = true;
            solution(cnt + 1, sum + energies[left] * energies[right]);
            visited[i] = false;
        }
    }
}