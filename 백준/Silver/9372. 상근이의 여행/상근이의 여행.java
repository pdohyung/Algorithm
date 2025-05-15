
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개국을 여행, 최대한 적은 종류의 비행기를 타고 이동
        // 스케줄이 주어질 때, 가장 적은 종류의 비행기를 타는 방법
        // 한 국가에서 다른 국가로 이동할 때, 다른 국가를 거쳐 가도 된다. (이미 방문한 국가도 가능)
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
            }

            answer.append(N - 1).append("\n");
        }

        System.out.println(answer);
    }
}
