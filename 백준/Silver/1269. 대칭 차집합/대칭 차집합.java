import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet<Integer> elements = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            elements.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < B; i++) {
            elements.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println((elements.size() - B) + (elements.size() - A));
    }
}
