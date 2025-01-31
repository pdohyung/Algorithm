
import java.util.*;
import java.io.*;

class Node {
    int w;
    int v;

    public Node(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        ArrayList<Node> things = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            things.add(new Node(w, v));
        }

//        System.out.println(things);

        for (int i = 0; i < N; i++) {
            Node now = things.get(i);
            int w = now.w;
            int v = now.v;

            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);
    }
}
