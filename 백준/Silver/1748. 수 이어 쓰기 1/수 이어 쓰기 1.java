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

        int size = String.valueOf(N).length();
        int first = (int) ((N - Math.pow(10, size - 1)) + 1) * size;
        int second = 0;

        for (int i = 0; i < size - 1; i++) {
            second += 9 * Math.pow(10, i) * (i + 1);
        }

        System.out.println(first + second);
    }
}