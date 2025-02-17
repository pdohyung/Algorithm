
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int length = 2 * N;
        int[] belt = new int[length];
        boolean[] robot = new boolean[N];
        int step = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) belt[i] = Integer.parseInt(st.nextToken());

        while (true) {
            // 회전
            for (int i = length - 1; i > 0; i--) {
                int before = belt[i - 1];
                belt[i - 1] = belt[i];
                belt[i] = before;

                // 회전하면서 로봇 이동
                if (i <= N) {
                    if (i == N) {
                        robot[i - 1] = false;
                        continue;
                    }
                    robot[i] = robot[i - 1];
                    robot[i - 1] = false;
                }
            }

            // 로봇만 이동
            for (int i = N; i > 0; i--) {
                if (i == N) {
                    robot[i - 1] = false;
                    continue;
                }
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    belt[i]--;
                }
            }

            // 올리는 위치에 로봇 추가
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 내구도 검사
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (belt[i] == 0) cnt++;
            }
            if (cnt >= K) break;

            // 단계 증가
            step++;
        }

        System.out.println(step);
    }
}
