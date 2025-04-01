
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int cnt = 0;
        char start = 'R';
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] == 'B') start = 'B';
            if (start == 'B' && chars[i] != start) cnt++;
        }
        int answer = cnt;

        cnt = 0;
        start = 'R';
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'B') start = 'B';
            if (start == 'B' && chars[i] != start) cnt++;
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        start = 'B';
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] == 'R') start = 'R';
            if (start == 'R' && chars[i] != start) cnt++;
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        start = 'B';
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'R') start = 'R';
            if (start == 'R' && chars[i] != start) cnt++;
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);
    }
}
