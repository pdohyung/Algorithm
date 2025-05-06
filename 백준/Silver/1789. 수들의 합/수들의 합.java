import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 1;

        while (true) {
            sum += cnt;
            if (sum > S) break;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
