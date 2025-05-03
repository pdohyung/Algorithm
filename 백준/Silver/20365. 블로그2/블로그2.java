import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = br.readLine().toCharArray();

        System.out.println(Math.min(find('R'), find('B')));
    }

    static int find(char target) {
        int idx = 0;
        boolean flag = false;
        int cnt = 1;

        while (idx < N) {
            while (idx < N && colors[idx] == target)  {
                idx++;
                flag = true;
            }

            if (flag) {
                cnt++;
                flag = false;
            }

            idx++;
        }

        return cnt;
    }
}
