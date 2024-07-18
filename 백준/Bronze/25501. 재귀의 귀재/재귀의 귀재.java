import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int cnt;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            cnt = 1;
            System.out.println(recursion(s, 0, s.length() - 1) + " " + cnt);
        }
    }

    static int recursion(String s, int left, int right) {
        if (left >= right) return 1;
        else if (s.charAt(left) != s.charAt(right)) return 0;
        else {
            cnt++;
            return recursion(s, left + 1, right - 1);
        }
    }
    
}