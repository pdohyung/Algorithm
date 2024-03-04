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
        int position = Integer.parseInt(br.readLine());

        System.out.println(sentence.charAt(position - 1));
    }
}