
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[H][W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            int now = Integer.parseInt(st.nextToken());
            for (int j = H - 1; j >= 0; j--) {
                if (now > 0) {
                    map[j][i] = true;
                    now--;
                }
            }
        }

        int answer = 0;

        for (int i = H - 1; i >= 0; i--) {
            int flag = 0;
            int cnt = 0;
            for (int j = 0; j < W; j++) {
//                System.out.println("좌표  = " + i + " " + j);
                if (flag == 0 && map[i][j]) {
                    flag = 1;
                } else if (flag == 1 && !map[i][j]) {
                    cnt++;
                } else if (flag == 1 && map[i][j] && cnt > 0) {
//                    System.out.println(cnt);
                    answer += cnt;
                    cnt = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
