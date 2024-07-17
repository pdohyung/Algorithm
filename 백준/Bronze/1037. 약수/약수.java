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
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < cnt; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        System.out.println(numbers.get(0) * numbers.get(numbers.size() - 1));
        return;
    }

}