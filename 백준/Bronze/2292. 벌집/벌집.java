import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 1, min = 1;

        if (N == 1) {
            System.out.println(cnt);
            return;
        }

        while (true) {
            cnt += min * 6;
            min++;
            //System.out.println(cnt);
            if (N <= cnt) {
                System.out.println(min);
                break;
            }
        }
    }

}
