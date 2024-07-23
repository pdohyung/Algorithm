import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, max, min;
    static int[] numbers;
    static char[] seq;
    static char[] operators;
    static boolean[] visited;
    static char[] sample = {'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        numbers = new int[N];
        seq = new char[N - 1];
        visited = new boolean[N - 1];
        operators = new char[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                operators[cnt] = sample[i];
                cnt++;
            }
        }

        //System.out.println(Arrays.toString(operators));

        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == N - 1) {
            int result = calculate(numbers[0]);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[depth] = operators[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int calculate(int result) {
        for (int i = 0; i < N - 1; i++) {
            switch (seq[i]) {
                case '+':
                    result += numbers[i + 1];
                    break;
                case '-':
                    result -= numbers[i + 1];
                    break;
                case '*':
                    result *= numbers[i + 1];
                    break;
                case '/':
                    result /= numbers[i + 1];
                    break;
            }
        }
        return result;
    }

}