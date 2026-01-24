import java.util.*;
import java.io.*;

public class Main {

    static int[] num;
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        answer = 0;

        for (int i = 0; i < N; i++) {
            find(num[i], i);
        }

        System.out.println(answer);
    }

    private static void find(int target, int i) {
        int left = 0;
        int right = num.length - 1;

        while (left < right) {
            int now = num[left] + num[right];
            if (now == target && left != i && right != i) {
                answer++;
                return;
            } else if (now > target) {
                right--;
            } else if (now < target) {
                left++;
            } else {
                if (left == i) left++;
                else right--;
            }
        }
    }
}
