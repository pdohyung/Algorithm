import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        } else {
            while (n > 0) {
                n -= 2;
                cnt++;
                if (n % 5 == 0) {
                    System.out.println(cnt + n / 5);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}