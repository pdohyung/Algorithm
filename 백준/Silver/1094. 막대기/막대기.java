import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        char[] binary = Integer.toBinaryString(X).toCharArray();
        int answer = 0;

        for (char c : binary) {
            if (c == '1') answer++;
        }

        System.out.println(answer);
    }
}
