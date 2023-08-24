import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        int[] w = new int[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            int num = n;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
            order[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (w[i] < w[j] && h[i] < h[j]) order[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(order[i] + " ");
        }
    }
}