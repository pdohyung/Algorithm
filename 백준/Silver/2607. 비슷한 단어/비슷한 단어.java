
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] original = br.readLine().toCharArray();
        int len = original.length;
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : original) map.put(c, map.getOrDefault(c, 0) + 1);

            int upLen = 0;
            int downLen = 0;
            char[] now = br.readLine().toCharArray();

            if (now.length >= len) {
                for (char c : now) {
                    if (map.containsKey(c) && map.get(c) != 0) map.put(c, map.get(c) - 1);
                    else upLen++;
                }
            } else {
                for (char c : now) {
                    if (map.containsKey(c) && map.get(c) != 0) {
                        map.put(c, map.get(c) - 1);
                        downLen++;
                    }
                }
            }

            if (upLen == 0 && (downLen == len || downLen == len - 1)) answer++;
            if (downLen == 0 && upLen <= 1) answer++;
        }

        System.out.println(answer);
    }
}
