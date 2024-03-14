import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = 1;

        while ((E != 1) || (S != 1) || (M != 1)) {
            E -= 1;
            S -= 1;
            M -= 1;

            year++;

            if (E == 0) {
                E = 15;
            }
            if (S == 0) {
                S = 28;
            }
            if (M == 0) {
                M = 19;
            }

        }

        System.out.print(year);
    }
}