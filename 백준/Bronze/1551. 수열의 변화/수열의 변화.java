import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N - 1; j++) {
                numbers[j] = numbers[j + 1] - numbers[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - K; i++) {
            sb.append(numbers[i]).append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
