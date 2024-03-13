import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String expression = br.readLine();
        int sum = 0;
        int res = 0;

        String[] splitByMinus = expression.split("-");

        for (int i = 0; i < splitByMinus.length; i++) {
            sum = calculate(splitByMinus[i]);

            if (i == 0) {
                res += sum;
            } else {
                res -= sum;
            }
        }

        System.out.println(res);
    }

    private int calculate(String splitByMinus) {
        String[] splitByPlus = splitByMinus.split("[+]");
        int sum = 0;

        for (String byPlus : splitByPlus) {
            sum += Integer.parseInt(byPlus);
        }

        return sum;
    }
}