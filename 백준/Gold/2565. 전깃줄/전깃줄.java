import java.util.*;
import java.io.*;

class Node {
    int s;
    int e;

    public Node(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new Node(s, e));
        }

        Collections.sort(lines, (o1, o2) -> Integer.compare(o1.s, o2.s));

        int[] dp = new int[lines.size()];
        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            Node node1 = lines.get(i);

            for (int j = 0; j < i; j++) {
                Node node2 = lines.get(j);
                if (node1.e > node2.e) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(N - max);
    }
}
