
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            char[] chars = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Map<Character, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < chars.length; i++) {
                List<Integer> now = map.getOrDefault(chars[i], new ArrayList<>());
                now.add(i);
                map.put(chars[i], now);
            }

            for (Character key : map.keySet()) {
                List<Integer> now = map.get(key);
                if (now.size() >= K) {
                    for (int i = 0; i <= now.size() - K; i++) {
                        min = Math.min(min, now.get(i + K - 1) - now.get(i) + 1);
                        max = Math.max(max, now.get(i + K - 1) - now.get(i) + 1);
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) answer.append(-1);
            else answer.append(min).append(" ").append(max);
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
