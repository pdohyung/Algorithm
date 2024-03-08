import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static String[] numbers;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        numbers = br.readLine().split(":");
        int N = Integer.parseInt(numbers[0]);
        int M = Integer.parseInt(numbers[1]);

        int gcd = gcd(Math.max(N, M), Math.min(N, M));

        System.out.println(N / gcd + ":" + M / gcd);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}