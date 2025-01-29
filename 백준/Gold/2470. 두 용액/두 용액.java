
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);

        int result = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        int s = 0;
        int e = N - 1;

        while (s < e) {
            int sum = value[s] + value[e];

            if (result > Math.abs(sum)) {
                result = Math.abs(sum);
                answer1 = value[s];
                answer2 = value[e];
            }

            if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
