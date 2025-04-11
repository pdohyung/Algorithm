import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int aCnt = 0;
        int bCnt = 0;
        for (char c : line.toCharArray()) if (c == 'a') aCnt++;

        int start = 0;
        int end = aCnt - 1;

        for (int i = start; i <= end; i++)
            if (line.charAt(i) == 'b') bCnt++;

        int min = bCnt;
        line += line;

        while (end < line.length() - 1) {
            if (line.charAt(start) == 'b') bCnt--;
            start++;
            end++;
            if (line.charAt(end) == 'b') bCnt++;
            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}
