import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static String now;
    static int N, ball, strike, answer;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[1000];

        // 정답 배열에서 숫자 야구 불가능한 수를 제거
        for (int i = 123; i <= 987; i++) {
            String num = String.valueOf(i);
            char f = num.charAt(0);
            char s = num.charAt(1);
            char t = num.charAt(2);

            if (f == '0' || s == '0' || t == '0') continue;
            if (f == s || s == t || f == t) continue;

            check[i] = true;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            now = st.nextToken();
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j <= 987; j++) {

                if (!check[j]) continue;

                int ns = 0;
                int nb = 0;

                String candidate = String.valueOf(j);
                for (int first = 0; first < 3; first++) {
                    for (int second = 0; second < 3; second++) {
                        if (now.charAt(first) == candidate.charAt(second)) {
                            if (first == second) ns++; // 스트라이크
                            else nb++; // 볼
                        }
                    }
                }

                if (ns != strike || nb != ball) {
                    check[j] = false;
                }
            }
        }

        answer = 0;
        for (int i = 123; i <= 987; i++) {
            if (check[i]) answer++;
        }

        System.out.println(answer);
    }
}
