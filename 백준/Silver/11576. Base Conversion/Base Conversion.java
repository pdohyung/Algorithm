import java.io.*;
import java.util.*;

public class Main {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[m];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = m - 1; i >= 0; i--) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            res += (numbers[i] * Math.pow(A, i));
        }

        while (res != 0) {
            stack.add(res % B);
            res /= B;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}