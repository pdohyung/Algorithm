import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] res = new String[T];

       for(int i = 0; i < T; i++) {
           String input = br.readLine();
           res[i] = checkVPS(input);
       }

        for(int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }
    }

    private static String checkVPS(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) return "NO";
                    stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }
}