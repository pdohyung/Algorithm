import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] rings = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            rings[i] = Integer.parseInt(st.nextToken());
        }

        int firstRing = rings[0];
        for (int i = 1; i < N; i++) {
            int gcd = gcd(firstRing, rings[i]);
            System.out.println(firstRing / gcd + "/" + rings[i] / gcd);
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

}