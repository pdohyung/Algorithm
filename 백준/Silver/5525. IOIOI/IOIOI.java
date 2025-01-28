
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int patternLength = 0;
        int cnt = 0;

        for (int i = 1; i < S - 1; i++) {
            if (line.charAt(i - 1) == 'I' && line.charAt(i) == 'O' && line.charAt(i + 1) == 'I') {
                patternLength++;
                if (patternLength >= N) cnt++;
                i++;
            } else {
                patternLength = 0;
            }
        }

        System.out.println(cnt);
    }
}
