import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        HashSet<String> uniqueNames = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String msg = br.readLine();

            if (msg.equals("ENTER")) {
                result += uniqueNames.size();
                uniqueNames = new HashSet<>();
                continue;
            }

            uniqueNames.add(msg);
        }

        System.out.println(result + uniqueNames.size());
        return;
    }

}