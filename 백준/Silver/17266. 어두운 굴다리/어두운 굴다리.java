import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // start = 0, end = N
        List<Integer> pos = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            pos.add(Integer.parseInt(st.nextToken()));
        }

        int answer = pos.get(0);
        if (M == 1) answer = Math.max(answer, N - pos.get(0));

        for (int i = 0; i < M - 1; i++) {
            int now = pos.get(i + 1) - pos.get(i);
            int half = now / 2;
            if (now % 2 != 0) half += 1;
            answer = Math.max(answer, half);
        }
        answer = Math.max(answer, N - pos.get(M - 1));

        System.out.println(answer);
    }
}
