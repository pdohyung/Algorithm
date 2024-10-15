import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int target = N % 100;

            if ((N + 1) % target == 0) {
                sb.append("Good").append("\n");
            } else {
                sb.append("Bye").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
