import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isReverse = true;

        for (Character c : line.toCharArray()) {
            if (c.equals('<')) {
                isReverse = false;
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append('<');
            } else if (c.equals('>')) {
                isReverse = true;
                result.append('>');
            } else if (c.equals(' ')) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
            } else {
                if (isReverse) {
                    stack.push(c);
                    continue;
                }
                result.append(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }
}