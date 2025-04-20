
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int n = 0;

        while (true) {
            n++;

            if (String.valueOf(n).contains("666")) {
                cnt++;
            }

            if (cnt == N) {
                System.out.println(n);
                return;
            }
        }
    }
}
