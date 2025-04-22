
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = A.length - 1;
        int cnt = 0;

        Arrays.sort(A);

        while (start < end) {
            int now = A[start] + A[end];

            if (now == x) {
                cnt++;
                start++;
                end--;
            } else if (now > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(cnt);
    }
}
