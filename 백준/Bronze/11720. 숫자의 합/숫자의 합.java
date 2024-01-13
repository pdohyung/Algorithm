import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] numbers = input.toCharArray();
        int sum = 0;

        for (char number : numbers) {
            sum += number - '0';
        }
        System.out.println(sum);
    }
}