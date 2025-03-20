
import java.util.*;
import java.io.*;

public class Main {

    static String input;
    static List<int[]> brackets;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        brackets = new ArrayList<>();
        answer = new TreeSet<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') brackets.add(new int[]{stack.pop(), i});
        }

        for (int i = 1; i <= brackets.size(); i++) {
            dfs(0, i, new boolean[brackets.size()]);
        }

        for (String s : answer) System.out.println(s);
    }

    private static void dfs(int depth, int limit, boolean[] used) {
        if (depth == limit) {
            addResult(used);
            return;
        }

        for (int i = depth; i < brackets.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(i + 1, limit, used);
                used[i] = false;
            }
        }
    }

    private static void addResult(boolean[] used) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> removeIdx = new HashSet<>();

        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                removeIdx.add(brackets.get(i)[0]);
                removeIdx.add(brackets.get(i)[1]);
            }
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!removeIdx.contains(i)) sb.append(c);
        }

        answer.add(sb.toString());
    }
}
