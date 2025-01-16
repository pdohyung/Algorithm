import java.io.*;
import java.util.*;

public class Main {

    static char[] def = {'+', '-', '*', '/'};
    static int N;
    static int[] A;
    static ArrayList<Character> tmp;
    static char[] ops;
    static boolean[] visited;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        tmp = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                tmp.add(def[i]);
            }
        }

        int size = tmp.size();
        ops = new char[size];
        visited = new boolean[size];

        for (int i = 0; i < ops.length; i++) {
            ops[i] = tmp.get(i);
        }

//        System.out.println(Arrays.toString(ops));
//        System.out.println(ops.length);
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(0, A[0]);

        System.out.println(max);
        System.out.println(min);
    }


    private static void dfs(int depth, int sum) {
        if (depth == ops.length) {
//            System.out.println(depth);
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, cal(sum, A[depth + 1], ops[i]));
                visited[i] = false;
            }
        }
    }

    private static int cal(int n1, int n2, int op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                return 0;
        }
    }
}
