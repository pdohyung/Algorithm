import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] pos = new int[4];
        pos[1] = 1;

        for (char c : line.toCharArray()) {
            if (c == 'A') {
                int temp = pos[1];
                pos[1] = pos[2];
                pos[2] = temp;
            } else if (c == 'B') {
                int temp = pos[2];
                pos[2] = pos[3];
                pos[3] = temp;
            } else if (c == 'C') {
                int temp = pos[3];
                pos[3] = pos[1];
                pos[1] = temp;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (pos[i] == 1) {
                System.out.println(i);
                return;
            }
        }
    }
}
