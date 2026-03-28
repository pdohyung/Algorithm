import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(process(0, 1, Arrays.copyOf(numbers, numbers.length)), process(1, 0, Arrays.copyOf(numbers, numbers.length))));
    }

    static long process(int l, int r, int[] numbers) {
        int left = 0;
        int right = 0;
        long cnt = 0;

        while (left <= right) {
            if (left == right) {
                if (right == N - 1) left++;
                else right++;
            } else if (numbers[left] % 2 == l && numbers[right] % 2 == r) {
                int temp = numbers[right];
                numbers[right] = numbers[left];
                numbers[left] = temp;
                cnt += right - left;
            } else if (numbers[left] % 2 == l) {
                if (right == N - 1) left++;
                else right++;
            } else if (numbers[right] % 2 == r) left++;
            else left++;
        }

        return cnt;
    }
}
