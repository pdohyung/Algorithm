import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();
        Stack<Object> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                int sum = 0;

                while (!stack.isEmpty()) {
                    Object top = stack.pop();

                    if (top instanceof Character) {
                        char open = (char) top;

                        if ((open == '(' && c == ')') || (open == '[' && c == ']')) {
                            int value = (c == ')') ? 2 : 3;

                            if (sum == 0) {
                                stack.push(value);
                            } else {
                                stack.push(sum * value);
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                        break;
                    } else if (top instanceof Integer) {
                        sum += (int) top;
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {
            Object top = stack.pop();
            if (top instanceof Character) {
                System.out.println(0);
                return;
            }
            answer += (int) top;
        }

        System.out.println(answer);
    }
}
