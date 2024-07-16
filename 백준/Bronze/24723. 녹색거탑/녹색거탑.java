import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        double N = Integer.parseInt(br.readLine());
        System.out.println((int) Math.pow(2, N));
        return;
    }
}