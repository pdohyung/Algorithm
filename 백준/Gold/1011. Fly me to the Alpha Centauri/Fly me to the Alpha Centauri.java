
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int d = Y - X;
            int n = (int) Math.sqrt(d);

            if (n == Math.sqrt(d)) {
                System.out.println(n * 2 - 1);
            } else if (d <= n * n + n) {
                System.out.println(n * 2);
            } else {
                System.out.println(n * 2 + 1);
            }
        }
    }
}
