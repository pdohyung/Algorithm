import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[][] sum;
    static String S;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 문자열을 받아서 알파벳별 누적합을 구한다.
        S = br.readLine();
        sum = new int[S.length() + 1][27];

        for (int i = 1; i <= S.length(); i++) {
            int alpha = S.charAt(i - 1) - 96;

            for (int j = 1; j <= 26; j++) {
                if (j == alpha) {
                    //System.out.println(j);
                    sum[i][j] = sum[i - 1][j] + 1;
                } else {
                    sum[i][j] = sum[i - 1][j];
                }
            }
        }

//        for (int i = 0; i < S.length(); i++) {
//            System.out.println(Arrays.toString(sum[i]));
//        }

        // 2. 질문을 받아서 결과를 반환한다.
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            String alpha = st.nextToken();
            int alphaIdx = alpha.charAt(0) - 96;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;

            int answer = sum[end][alphaIdx] - sum[start][alphaIdx];
//            System.out.println(sum[end][alphaIdx] + " " + sum[start][alphaIdx]);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
