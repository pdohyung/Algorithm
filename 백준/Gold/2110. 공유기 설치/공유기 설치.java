import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int low = 1;
        int high = houses[N - 1] - houses[0];

        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            int cnt = 1;
            int before = houses[0];

            for (int i = 1; i < N; i++) {
                if (houses[i] - before >= mid) {
                    cnt++;
                    before = houses[i];
                }
            }

            if (cnt >= C) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
