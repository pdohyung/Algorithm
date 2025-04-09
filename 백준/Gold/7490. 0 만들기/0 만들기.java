import java.util.*;
import java.io.*;

public class Main {

    static List<String>[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        result = new ArrayList[10];
        for (int i = 3; i <= 9; i++) result[i] = new ArrayList<>();

        dfs(1, "1");
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<String> zeros = new ArrayList<>();

            for (String s : result[N]) {
                String now = s.replaceAll(" ", "");
                List<Integer> numbers = new ArrayList<>();
                List<Character> opers = new ArrayList<>();
                StringBuilder sb = new StringBuilder();

                for (char c : now.toCharArray()) {
                    if (c == '+' || c == '-') {
                        numbers.add(Integer.parseInt(sb.toString()));
                        opers.add(c);
                        sb = new StringBuilder();
                    } else sb.append(c);
                }
                numbers.add(Integer.parseInt(sb.toString()));

                for (int o = 0; o < opers.size(); o++) {
                    char oper = opers.get(o);

                    if (oper == '+') {
                        int sum = numbers.get(o) + numbers.get(o + 1);
                        numbers.set(o + 1, sum);
                    } else if (oper == '-') {
                        int sum = numbers.get(o) - numbers.get(o + 1);
                        numbers.set(o + 1, sum);
                    }
                }

                if (numbers.get(numbers.size() - 1) == 0) zeros.add(s);
            }

            Collections.sort(zeros);
            for (String s : zeros) answer.append(s).append("\n");
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static void dfs(int n, String s) {
        if (n > 9) return;
        if (n >= 3) result[n].add(s);

        int next = n + 1;
        dfs(next, s + "+" + next);
        dfs(next, s + " " + next);
        dfs(next, s + "-" + next);
    }
}
