
import java.util.*;
import java.io.*;

public class Main {

    static String line1;
    static String line2;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line1 = br.readLine();
        line2 = br.readLine();

        StringBuilder result = new StringBuilder();
        result.append(line2);

        answer = 0;

        while (result.length() > line1.length()) {
            int last = result.length() - 1;
            if (result.charAt(last) == 'B') {
                result.deleteCharAt(last);
                result.reverse();
            } else {
                result.deleteCharAt(last);
            }
        }

        if (result.toString().equals(line1)) answer = 1;

        System.out.println(answer);
    }
}
