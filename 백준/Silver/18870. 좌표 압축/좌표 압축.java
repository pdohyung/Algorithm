import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> original = new ArrayList<>();
        for (int i = 0; i < N; i++) original.add(Integer.parseInt(st.nextToken()));

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>(original);
        Stack<Integer> stack = new Stack<>();
        for (int n : set) stack.push(n);

        while (!stack.isEmpty()) {
            int n = stack.pop();
            map.put(n, stack.size());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) answer.append(map.get(original.get(i))).append(" ");
        System.out.println(answer);
    }
}
