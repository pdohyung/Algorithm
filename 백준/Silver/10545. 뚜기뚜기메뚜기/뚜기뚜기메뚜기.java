import java.io.*;
import java.util.*;

public class Main {

    static char[][] dial = {
            {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> mapping = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            mapping.put(Integer.parseInt(st.nextToken()) - 1, i);
        }

        char[] letter = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        int before = 0;

        for (char now : letter) {
            int[] res = find(now);
            int num = mapping.get(res[0]) + 1;
            if (before == num) answer.append("#");
            for (int i = 0; i < res[1]; i++) answer.append(num);
            before = num;
        }

        System.out.println(answer);
    }

    static int[] find(char now) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < dial[i].length; j++) {
                if (dial[i][j] == now) {
                    return new int[]{i, j + 1};
                }
            }
        }
        return new int[]{0, 0};
    }
}
