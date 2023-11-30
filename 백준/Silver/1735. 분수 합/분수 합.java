import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c1 = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        c1 = c1 * p2 + c2 * p1;
        p1 = p1 * p2;
        int gcd = getGcd(c1, p1);

        System.out.println(c1 / gcd + " " + p1 / gcd);
    }

    public static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
}