import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a %= 10;

            if (a == 0) {
                System.out.println(10);
            }

            if (a == 1 || a == 5 || a == 6) {
                System.out.println(a);
                continue;
            }

            if (a == 4 || a == 9) {
                int rest = b % 2;
                if (rest == 0) {
                    rest = 2;
                }
                System.out.println((int) Math.pow(a, rest) % 10);
                continue;
            }

            if (a == 2 || a == 3 || a == 7 || a == 8) {
                int rest = b % 4;
                if (rest == 0) {
                    rest = 4;
                }
                System.out.println((int) Math.pow(a, rest) % 10);
            }
        }
    }
}