import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String sentence = br.readLine();
        String[] croatiaAlp = {"dz=", "lj", "nj", "c=", "c-", "d-", "s=", "z="};

        for (String s : croatiaAlp) {
            if (sentence.contains(s)) {
                sentence = sentence.replace(s, "0");
            }
        }

        System.out.println(sentence.length());
    }
}