
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] elements = br.readLine().toCharArray();
            int length = elements.length;

            int left = 0;
            int s = 0;
            int e = length - 1;

            while (s < e) {
                if (elements[s] != elements[e]) {
                    s++;
                    left++;
                    if (left >= 2) break;
                } else {
                    s++;
                    e--;
                }
            }

            int right = 0;
            s = 0;
            e = length - 1;

            while (s < e) {
                if (elements[s] != elements[e]) {
                    e--;
                    right++;
                    if (right >= 2) break;
                } else {
                    s++;
                    e--;
                }
            }

            int answer = 0;
            if (left == 1 || right == 1) answer = 1;
            else if (left == 2 || right == 2) answer = 2;

            System.out.println(answer);
        }
    }
}
