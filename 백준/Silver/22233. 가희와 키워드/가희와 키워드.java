
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] words = line.split(",");

            for (String w : words) {
                set.remove(w);
            }

            answer.append(set.size()).append("\n");
        }

        System.out.println(answer);
    }
}
