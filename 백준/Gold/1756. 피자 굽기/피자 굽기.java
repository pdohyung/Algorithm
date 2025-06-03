
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 관 모양으로 되어있는 오븐에 완성된 피자를 순서대로 넣고나서, 가장 위에 있는 피자의 위치를 출력, 피자가 모두 오븐에 못들어가면 0을 출력
        // D, N의 최대가 30만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] S = new int[D];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < D; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < D; i++) {
            S[i] = Math.min(S[i], S[i - 1]);
        }

        st = new StringTokenizer(br.readLine());
        int before = D - 1;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = before;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (S[mid] >= t) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (end < 0) {
                answer = 0;
                break;
            }

            before = end - 1;
            answer = end + 1;
        }

        System.out.println(answer);
    }
}
