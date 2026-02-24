
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> cnt = List.of(3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        StringBuilder mix = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            mix.append(cnt.get(A.charAt(i) - 'A')).append(cnt.get(B.charAt(i) - 'A'));
        }

        StringBuilder now = new StringBuilder(mix);

        while (now.length() > 2) {
            mix = new StringBuilder();

            for (int i = 0; i < now.length() - 1; i++) {
                mix.append((now.charAt(i) - '0' + now.charAt(i + 1) - '0') % 10);
            }

            now = new StringBuilder(mix);
        }

        System.out.println(now);
    }
}
