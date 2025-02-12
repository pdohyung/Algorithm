import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        int cnt = 0;

        for (char c : line.toCharArray()) {
            if (c == 'M') {
                cnt++;
            } else {
                max.append("5");
                for (int i = 0; i < cnt; i++) max.append("0");
                cnt = 0;
            }
        }
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) max.append("1");
        }

        cnt = 0;

        for (char c : line.toCharArray()) {
            if (c == 'M') {
                cnt++;
            } else {
                if (cnt > 0) {
                    min.append("1");
                    for (int i = 0; i < cnt - 1; i++) min.append("0");
                    min.append("5");
                    cnt = 0;
                } else {
                    min.append("5");
                }
            }
        }
        if (cnt > 0) {
            min.append("1");
            for (int i = 0; i < cnt - 1; i++) min.append("0");
        }

        System.out.println(max);
        System.out.println(min);
    }
}
