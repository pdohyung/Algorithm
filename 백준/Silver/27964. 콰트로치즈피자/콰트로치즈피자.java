import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> result = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String line = st.nextToken();
            if (line.length() < 6) continue;
            String substring = line.substring(line.length() - 6, line.length());
            if (substring.equals("Cheese")) {
                result.add(line);
            }
        }

        if (result.size() < 4) System.out.println("sad");
        else System.out.println("yummy");
    }
}
