import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < N; i++) stack.push(Integer.parseInt(st.nextToken()));

            long result = 0;

            while (!stack.isEmpty()) {
                int now = stack.peek();
                long sum = 0;
                long cnt = 0;

                while (!stack.isEmpty() && stack.peek() <= now) {
                    cnt++;
                    sum += stack.pop();
                }

                result += now * cnt - sum;
            }

            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }
}
