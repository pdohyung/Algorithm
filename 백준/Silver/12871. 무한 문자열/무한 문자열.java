import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder fs = new StringBuilder();
        StringBuilder ft = new StringBuilder();

        for (int i = 0; i < t.length(); i++) fs.append(s);
        for (int i = 0; i < s.length(); i++) ft.append(t);

        System.out.println((fs.compareTo(ft) == 0) ? 1 : 0);
    }
}
