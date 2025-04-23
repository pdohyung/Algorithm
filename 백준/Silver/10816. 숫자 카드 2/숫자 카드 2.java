import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (map.containsKey(now)) {
                answer.append(map.get(now));
            } else {
                answer.append(0);
            }

            answer.append(" ");
        }

        System.out.println(answer);
    }
}
