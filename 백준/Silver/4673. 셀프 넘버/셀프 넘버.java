import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        numbers = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            selfNumber(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!numbers[i]) {
                System.out.println(i);
            }
        }
    }

    private void selfNumber(int number) {
        int res = number;
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        if (res > 10000) {
            return;
        }
        numbers[res] = true;
        selfNumber(res);
    }
}