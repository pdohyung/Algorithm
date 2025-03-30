
import java.util.*;
import java.io.*;

public class Main {

    static String S;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        answer = 0;
        dfs(T);
        System.out.println(answer);
    }

    private static void dfs(StringBuilder t) {
        if (t.length() == S.length()) {
            if (t.toString().equals(S)) answer = 1;
            return;
        }

        StringBuilder case1 = new StringBuilder().append(t);
        StringBuilder case2 = new StringBuilder().append(t);

        if (case1.charAt(case1.length() - 1) == 'A') dfs(case1.deleteCharAt(case1.length() - 1));
        if (case2.charAt(0) == 'B') dfs(case2.reverse().deleteCharAt(case2.length() - 1));
    }
}
