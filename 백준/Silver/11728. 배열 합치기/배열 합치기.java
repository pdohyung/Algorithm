import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] n = new int[a];
        int[] m = new int[b];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < a; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < b; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 < a && p2 < b) {
            if (n[p1] < m[p2]) {
                sb.append(n[p1++]).append(" ");
                continue;
            }
            sb.append(m[p2++]).append(" ");
        }

        while (p1 < a) {
            sb.append(n[p1++]).append(" ");
        }

        while (p2 < b) {
            sb.append(m[p2++]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
