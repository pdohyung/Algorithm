
import java.util.*;
import java.io.*;

public class Main {

    static int r, c, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        recursion(0, 0, size);

        System.out.println(answer);
    }

    private static void recursion(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int blockSize = half * half;

        if (r < row + half && c < col + half) {
            recursion(row, col, half);
        } else if (r < row + half) {
            answer += blockSize;
            recursion(row, col + half, half);
        } else if (c < col + half) {
            answer += 2 * blockSize;
            recursion(row + half, col, half);
        } else {
            answer += 3 * blockSize;
            recursion(row + half, col + half, half);
        }
    }
}
