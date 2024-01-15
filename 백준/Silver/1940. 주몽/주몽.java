import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int startIdx = 0;
        int endIdx = n - 1;
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        while (endIdx > startIdx) {
            sum = numbers.get(startIdx) + numbers.get(endIdx);
            if (sum == m) {
                ans++;
                endIdx--;
                continue;
            }
            if (sum > m) {
                endIdx--;
                continue;
            }
            startIdx++;
        }
        System.out.println(ans);
    }
}