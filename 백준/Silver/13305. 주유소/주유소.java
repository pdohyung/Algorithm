import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N - 1];
        int[] p = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) d[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());

        long min = Integer.MAX_VALUE;
        long result = 0;

        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, p[i]);
            result += min * d[i];
        }

        System.out.println(result);
    }
}
