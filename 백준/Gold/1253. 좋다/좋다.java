import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static long[] numbers;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        numbers = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int startIdx = 0;
        int endIdx = 0;
        int ans = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            startIdx = 0;
            endIdx = n - 1;
            while (endIdx > startIdx) {
                sum = numbers[startIdx] + numbers[endIdx];
                if (sum < numbers[i] || i == startIdx) {
                    startIdx++;
                    continue;
                }
                if (sum > numbers[i] || i == endIdx) {
                    endIdx--;
                    continue;
                }
                if (sum == numbers[i]) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}