import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] numbers = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[] psum = new long[n + 1];
        long sum = 0;

        for (int i = 1; i < n + 1; i++) {
            psum[i] = psum[i - 1] + numbers[n + 1 - i];
            sum += numbers[n - i] * psum[i];
        }
        System.out.println(sum);
    }
}