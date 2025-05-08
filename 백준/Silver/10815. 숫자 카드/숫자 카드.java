
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> numbers = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            numbers.put(k, numbers.getOrDefault(k, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());

            if (numbers.containsKey(k)) {
                answer.append(1);
            } else {
                answer.append(0);
            }

            answer.append(" ");
        }

        System.out.println(answer);
    }
}
