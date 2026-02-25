import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringBuilder result = new StringBuilder();

        while (n != 0) {
            List<String> names = new ArrayList<>();
            boolean[] check = new boolean[n];
            for (int i = 0; i < n; i++) names.add(br.readLine());

            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                check[num - 1] = !check[num - 1];
            }

            result.append(++cnt).append(" ");

            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    result.append(names.get(i)).append("\n");
                    break;
                }
            }

            n = Integer.parseInt(br.readLine());
        }

        System.out.println(result);
    }
}
