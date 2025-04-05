import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int pos = 0;
        int base = 0;

        while (true) {
            base++;
            String now = String.valueOf(base);
            for (int i = 0; i < now.length(); i++) {
                if (now.charAt(i) == input.charAt(pos)) pos++;
                if (pos == input.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
