
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        int[] result = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);

        int mid = 0;

        for (int i = 0; i < N; i++) {
            if (value[i] > 0) {
                mid = i;
                break;
            }
        }

//        System.out.println(Arrays.toString(value));

        int s = 0;
        int e = N - 1;

        result[0] = Math.abs(value[s] + value[e]);
        result[1] = value[s];
        result[2] = value[e];

        while (s < e) {
            int left = Math.abs(value[s] + value[e - 1]);
            int right = Math.abs(value[s + 1] + value[e]);

            if (e - 1 == s || s + 1 == e) break;

//            System.out.println(s + " " + e);
//            System.out.println(left + " " + right);
//            System.out.println();

            if (left <= right && e > mid) {
                e--;
                if (result[0] > left) {
                    result[0] = left;
                    result[1] = value[s];
                    result[2] = value[e];
                }
            } else {
                s++;
                if (result[0] > right) {
                    result[0] = right;
                    result[1] = value[s];
                    result[2] = value[e];
                }
            }
//            System.out.println(Arrays.toString(result));
        }
        System.out.println(result[1] + " " + result[2]);
    }
}
