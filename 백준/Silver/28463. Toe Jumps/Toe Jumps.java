import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> dir = Map.of("S", 0, "E", 1, "N", 2, "W", 3);
    static String[] T = {".O", "P."};
    static String[] F = {"I.", ".P"};
    static String[] L = {"O.", ".P"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = dir.get(br.readLine()) - dir.get("S");
        String[] now = new String[2];
        now[0] = br.readLine();
        now[1] = br.readLine();

        if (match(rotate(T, cnt), now)) System.out.println("T");
        else if (match(rotate(F, cnt), now)) System.out.println("F");
        else if (match(rotate(L, cnt), now)) System.out.println("Lz");
        else System.out.println("?");
    }

    static boolean match(String[] result, String[] now) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (result[i].charAt(j) != now[i].charAt(j)) return false;
            }
        }
        return true;
    }

    static String[] rotate(String[] now, int cnt) {
        String s = now[0] + now[1];

        for (int i = 0; i < cnt; i++) {
            char[] next = new char[4];
            next[1] = s.charAt(3);
            next[3] = s.charAt(2);
            next[2] = s.charAt(0);
            next[0] = s.charAt(1);
            s = new String(next);
        }

        return new String[]{s.substring(0, 2), s.substring(2, 4)};
    }
}
