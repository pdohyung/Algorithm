
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 고양이가 인식할 수 있는 최대 알파벳 개수로 주어지는 문자열의 최대 길이를 출력
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        char[] str = br.readLine().strip().toCharArray();

        int left = 0;
        int right = -1;
        int cnt = 0;
        int answer = 0;

        while (right + 1 < str.length) {
            int now = str[++right] - 'a';
            if (alpha[now]++ == 0) cnt++;

            while (cnt > N) {
                int rm = str[left++] - 'a';
                if (--alpha[rm] == 0) cnt--;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}
