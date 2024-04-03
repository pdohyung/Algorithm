import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static List<Integer> S;
    static StringBuilder sb;
    static int M;
    static int x;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        sb = new StringBuilder();
        S = new ArrayList<>();
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if (!method.equals("all") && !method.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (method) {
                case "add":
                    add(x);
                    break;
                case "remove":
                    remove(x);
                    break;
                case "check":
                    sb.append(check(x)).append("\n");
                    break;
                case "toggle":
                    toggle(x);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.println(sb);
    }

    private void add(int x) {
        if (S.contains(x)) {
            return;
        }
        S.add(x);
    }

    private void remove(int x) {
        if (!S.contains(x)) {
            return;
        }
        int idx = S.indexOf(x);
        S.remove(idx);
    }

    private int check(int x) {
        if (S.contains(x)) {
            return 1;
        }
        return 0;
    }

    private void toggle(int x) {
        if (S.contains(x)) {
            int idx = S.indexOf(x);
            S.remove(idx);
            return;
        }
        S.add(x);
    }

    private void all() {
        S.clear();
        IntStream.rangeClosed(1, 20)
                .forEach(S::add);
    }

    private void empty() {
        S.clear();
    }

}